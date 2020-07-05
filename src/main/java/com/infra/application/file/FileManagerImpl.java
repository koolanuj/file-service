package com.infra.application.file;

import com.infra.application.file.exceptions.InvalidFileException;
import com.infra.domain.file.FileAttributeBuilder;
import com.infra.domain.file.FileAttributes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.List;

@Slf4j
@Component("fileManager")
public class FileManagerImpl implements FileManager {

    private static final int MAX_DEPTH_DIR_TRAVERSAL = 20;

    @Autowired
    private CustomFileVisitor customFileVisitor;    //needed for action taken while file is being traversed by walkFileTree()

    /**
     * @see FileManager#getFileDetails(String)
     *
     * @param fileAbsolutePath - absolute path of the file
     * @return
     * @throws Exception
     */
    @Override
    public FileAttributes getFileDetails(String fileAbsolutePath) throws Exception {
        handleValidation(fileAbsolutePath);
        Path filePath = Paths.get(fileAbsolutePath);
        return getFileDetails(filePath);
    }

    /**
     * @see FileManager#getFileDetails(Path)
     *
     * @param filePath
     * @return
     * @throws Exception
     */
    @Override
    public FileAttributes getFileDetails(Path filePath) throws Exception {
        log.debug("Fetching details for file - " + filePath);
        FileAttributes fileAttr = null;
        try {
            BasicFileAttributes basicFileAttributes = Files.readAttributes(filePath, BasicFileAttributes.class);
            fileAttr = FileAttributeBuilder.buildFile(filePath, basicFileAttributes);
        } catch (IOException e) {
            log.warn(e.toString());
        }

        log.debug("Details fetched for file:'" + filePath + "' are: " + fileAttr);
        return fileAttr;
    }

    /**
     * @see FileManager#getDirDetails(String)
     *
     * @param dirAbsolutePath - - absolute path of the directory
     * @return
     * @throws Exception
     */
    @Override
    public List<FileAttributes> getDirDetails(String dirAbsolutePath) throws Exception {
        handleValidation(dirAbsolutePath);
        Path path = Paths.get(dirAbsolutePath);
        return getDirDetails(path);
    }

    /**
     * @see FileManager#getDirDetails(Path)
     *
     * @param dirAbsolutePath
     * @return
     * @throws Exception
     */
    @Override
    public List<FileAttributes> getDirDetails(Path path) throws Exception {
        log.info("Fetching details for DIR - " + path);

        // follow links when copying files
        EnumSet<FileVisitOption> fileVisitOptions = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

        try {
            Files.walkFileTree(path, fileVisitOptions, MAX_DEPTH_DIR_TRAVERSAL, customFileVisitor);
        } catch (IOException e) {
            log.error("Error occurred during dir traversal, details are:" + e);
        }
        log.info("Details fetched for DIR:'" + path);
        return customFileVisitor.getFileList();
    }

    /**
     * @see FileManager#handleValidation(String)
     *
     * @param fileToCheck - absolute path of file to check
     * @throws Exception
     */
    @Override
    public void handleValidation(String fileToCheck) throws Exception {
        boolean fileExists = true;
        log.debug("Checking if file exists or not: '" + fileToCheck + "'");

        if (StringUtils.isEmpty(fileToCheck)) {
            log.error("Filename provided is empty, can't do anything!");
            fileExists = false;
        } else if (!(new File(fileToCheck).exists())) {     //check if file exists??
            log.error("Filename provided doesn't exist in filesystem:'" + fileToCheck + "'");
            fileExists = false;
        }

        if (!fileExists) {
            throw new InvalidFileException("Supplied file doesn't exists in the filesystem, file='" + fileToCheck + "'");
        }
    }

}
