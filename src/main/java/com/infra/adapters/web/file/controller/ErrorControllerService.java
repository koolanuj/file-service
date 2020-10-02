package com.infra.adapters.web.file.controller;

import com.infra.adapters.util.FileErrorUtil;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Create a custom error page, will be rendered when any kind of error/exception occurs in the system
 * It uses thymeleaf template from resources/templates/*.html
 * Some of the data for the page is populated in (@link org.springframework.ui.Model)
 * object from class/method which are called during processing
 */
@RestController
//@ControllerAdvice
public class ErrorControllerService implements ErrorController {

    private final static String ERROR_PATH = "/error";

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @GetMapping(value=ERROR_PATH, produces = "text/html")
    public ModelAndView handleError() {
        ModelAndView modelAndView = new ModelAndView();
        //modelAndView.addAllObjects(populateErrorViewDetails());
        modelAndView.addObject("usage", FileErrorUtil.getUsageStr());
        modelAndView.setViewName("error");  //name has to be same as template configured, in this case its resources/template/error.html
        return modelAndView;
    }

}
