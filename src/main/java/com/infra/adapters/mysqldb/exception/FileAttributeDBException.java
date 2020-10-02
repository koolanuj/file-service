package com.infra.adapters.mysqldb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FileAttributeDBException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FileAttributeDBException() {
        super("File does not exist in DB");
    }

}
