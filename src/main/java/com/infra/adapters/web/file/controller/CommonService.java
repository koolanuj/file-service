package com.infra.adapters.web.file.controller;

import com.infra.adapters.web.util.FileErrorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Welcome page to print usage only
 */
@Slf4j
@RestController
public class CommonService {

    @GetMapping(value={"/", "/welcome"}, produces = "text/html")
    public String home(){
        //TODO: customize it with welcome.html template
        return FileErrorUtil.getUsageStr();
    }

}
