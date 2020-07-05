package com.infra.application.file;

/**
 * Stores various file types as returned by {@link java.nio.file.attribute.BasicFileAttributes}
 */
public enum FileTypeEnum {
    REGULAR_FILE("regular-file"),
    DIRECTORY("dir"),
    SYMBOLIC_LINK("symlink"),
    OTHER_FILE_TYPE("other-file-type");

    private String fileTypeDesc;

    private FileTypeEnum(String fileTypeDesc) {
        this.fileTypeDesc = fileTypeDesc;
    }

    public String getFileTypeDesc() {
        return this.fileTypeDesc;
    }

}
