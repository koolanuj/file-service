package com.infra.application.file.exceptions;

/**
 * Custom exception for cases where file provided is not valid or blank
 */
public class InvalidFileException extends Exception {

    private static final long serialVersionUID = -333229234265371L;

    public InvalidFileException(String message) {
        super(message);
    }

}
