package com.infra.application.file.exceptions;

/**
 * List down attributes which needs to be populated in error.html file
 */
public enum ErrorAttributeEnum {
    PATH("path"),
    STATUS("status"),
    TIMESTAMP("timestamp"),
    ERROR_SHORT_MSG("errorShortMsg"),
    ERROR_DETAILS("errorDetails");

    String attr;

    private ErrorAttributeEnum(String attr) {
        this.attr = attr;
    }

    public String getAttr() {
        return this.attr;
    }

}
