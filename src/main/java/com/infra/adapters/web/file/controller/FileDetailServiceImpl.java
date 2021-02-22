package com.infra.adapters.web.file.controller;


import com.infra.application.file.FileManager;
import com.infra.domain.file.FileAttributes;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@Component("fileDetailService")
public class FileDetailServiceImpl implements FileDetailService {

    @Autowired
    FileManager fileManager;

    @Override
    @Operation(summary = "Get attributes of the given file, provided in query string as absolute path")
    @GetMapping(value="/fileservice/filedetail", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<FileAttributes> getFileDetails(@RequestParam(name="fileName") String file) throws Exception {
        log.debug("File name extracted from GET request:" + file);
        return new ResponseEntity<FileAttributes>(fileManager.getFileDetails(file), HttpStatus.OK);
    }

}
