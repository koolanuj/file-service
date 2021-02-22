package com.infra.application.util;

import com.infra.application.file.FileTypeEnum;

import java.nio.file.attribute.BasicFileAttributes;

public class FileTypeUtil {

    public static FileTypeEnum determineFileType(final BasicFileAttributes basicFileAttributes) {
        if (basicFileAttributes.isRegularFile()) {
            return FileTypeEnum.REGULAR_FILE;
        }
        else if (basicFileAttributes.isDirectory()) {
            return FileTypeEnum.DIRECTORY;
        }
        else if (basicFileAttributes.isSymbolicLink()) {
            return FileTypeEnum.SYMBOLIC_LINK;
        }
        else {
            return FileTypeEnum.OTHER_FILE_TYPE;
        }
    }
}
