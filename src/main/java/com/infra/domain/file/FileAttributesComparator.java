package com.infra.domain.file;

import org.thymeleaf.util.StringUtils;

import java.util.Comparator;

/**
 * Excluding datetime related attributes
 */
public class FileAttributesComparator implements Comparator<FileAttributes> {

    @Override
    public int compare(FileAttributes fileAttr1, FileAttributes fileAttr2) {
        if (fileAttr1 == null || fileAttr2 == null) {
            return -1;
        }
        boolean result =  (StringUtils.equals(fileAttr1.getName(), fileAttr2.getName()) &&
                StringUtils.equals(fileAttr1.getPath(), fileAttr2.getPath()) &&
                StringUtils.equals(replaceFileSeparator(fileAttr1.getFileType()), replaceFileSeparator(fileAttr2.getFileType())) &&
                (fileAttr1.getSize() == fileAttr2.getSize()));
        return result ? 0 : -1;
    }

    private String replaceFileSeparator (String fileStr) {
        return fileStr.replace("/" , "").replace("\\", "");
    }
}
