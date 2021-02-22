package com.infra.adapters.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {

    private static final String DATE_FORMAT_FS_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_FS_DEFAULT);

    public static LocalDateTime convertStrToDateTime(String dateStr) {
        return LocalDateTime.parse(dateStr, formatter);
    }
}
