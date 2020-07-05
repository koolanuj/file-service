package com.infra.application.file.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.time.LocalDateTime;

/**
 * Defines how to handle different types of exception which can potentially occur in the application
 * Its applicable to all REST services defined in the application
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {//} extends ResponseEntityExceptionHandler {

    @ModelAttribute
    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Requested file/dir not found") //404
    @ExceptionHandler({InvalidFileException.class, NoSuchFileException.class, IOException.class})
    public void handleInvalidFileException(HttpServletRequest request, Exception ex, Model model) {
        populateCommonErrorAttributes(request, ex, model);
        log.error("Handling InvalidFileException/NoSuchFileException/IOException, details are: " + ex);
    }

//    @ModelAttribute
//    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Some error/exception occurred") //404
//    @ExceptionHandler(Exception.class)
//    public void handleException(HttpServletRequest request, Exception ex, Model model) {
//        populateCommonErrorAttributes(request, ex, model);
//        log.error("Handling Exception, details are: " + ex.getStackTrace().toString());
//    }

    private void populateCommonErrorAttributes(HttpServletRequest request, Exception ex, Model model) {
        model.addAttribute(ErrorAttributeEnum.PATH.getAttr(), request.getRequestURL().toString());
        model.addAttribute(ErrorAttributeEnum.STATUS.getAttr(), HttpStatus.NOT_FOUND.toString());
        model.addAttribute(ErrorAttributeEnum.TIMESTAMP.getAttr(), LocalDateTime.now());
        model.addAttribute(ErrorAttributeEnum.ERROR_SHORT_MSG.getAttr(), ex.getMessage());
        //model.addAttribute(ErrorAttributeEnum.ERROR_DETAILS.getAttr(), stackTraceToString(ex));
    }

    private String stackTraceToString(Throwable e) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : e.getStackTrace()) {
            sb.append(element.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}


