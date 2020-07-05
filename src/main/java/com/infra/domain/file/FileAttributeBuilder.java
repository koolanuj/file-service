package com.infra.domain.file;

import com.infra.application.util.FileTypeUtil;

import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class FileAttributeBuilder {

    public static FileAttributes buildFile(Path filePath, BasicFileAttributes basicFileAttributes) {
        return FileAttributes.builder()
                .name(filePath.getFileName().toString())
                .path(filePath.toAbsolutePath().toString())
                .size(basicFileAttributes.size())
                .fileType(FileTypeUtil.determineFileType(basicFileAttributes).getFileTypeDesc())
                .accessTime(basicFileAttributes.lastAccessTime().toString())
                .creationTime(basicFileAttributes.creationTime().toString())
                .lastModifiedTime(basicFileAttributes.lastModifiedTime().toString())
                .build();
    }
}
