package com.infra.application.file;

import com.infra.domain.file.FileAttributes;

import java.nio.file.Path;
import java.util.List;

public interface FileManager {

    /**
     * Get attributes of given File from filesystem
     *
     * @param fileAbsolutePath - absolute path of the file
     * @return
     * @throws Exception
     */
    public FileAttributes getFileDetails(String fileAbsolutePath) throws Exception;

    /**
     * @see FileManager#getFileDetails(String)
     *
     * @param filePath
     * @return
     * @throws Exception
     */
    public FileAttributes getFileDetails(Path filePath) throws Exception;

    /**
     * Get attributes of ALL files and directories recursively for the provided directory from filesystem
     *
     * @param dirAbsolutePath - - absolute path of the directory
     * @return - List of files/directory objects containining their attributes
     * @throws Exception
     */
    public List<FileAttributes> getDirDetails(String dirAbsolutePath) throws Exception;

    /**
     * @see FileManager#getDirDetails(String)
     */
    public List<FileAttributes> getDirDetails(Path dirAbsolutePath) throws Exception;

    /**
     * Do basic validation of supplied file or directory like null, invalid etc
     *
     * @param fileToCheck - absolute path of file to check
     * @throws Exception
     */
    public void handleValidation(String fileToCheck) throws Exception;
}
