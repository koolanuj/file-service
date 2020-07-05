package com.infra.application.file;

import com.infra.domain.file.FileAttributeBuilder;
import com.infra.domain.file.FileAttributes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * Overriden methods determine what action needs to be taken when file is being visited during
 * (@link java.nio.Files.walkFileTree()) operation
 */
@Slf4j
@Component("customFileVisitor")
public class CustomFileVisitor implements FileVisitor<Path> {

    private List<FileAttributes> fileList = new ArrayList<>();

    public List<FileAttributes> getFileList() {
        return this.fileList;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes fileAttributes) throws IOException {
        //build our custom file object and add to our list
        fileList.add(FileAttributeBuilder.buildFile(file, fileAttributes));
        String filePathStr = file.toAbsolutePath().toString();

        if (fileAttributes.isSymbolicLink()) {
            log.debug("Found a Symbolic link:" + filePathStr);
        } else if (fileAttributes.isDirectory()) {
            log.debug("Found a Directory:", filePathStr);
        } else if (fileAttributes.isRegularFile()) {
            log.debug("Found a regular file, getting attributes: " + filePathStr);
        } else {
            log.debug("Found something which is not dir or regular file or link: " + filePathStr);
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        if (exc instanceof FileSystemLoopException) {
            log.error("Detected a cycle during file traversal, not a good thing : " + file);
        } else {
            log.error("Error reading file: %s: %s%n", file, exc);
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        log.info("Done traversing dir:'" + dir + "'");
        return CONTINUE;
    }
}
