package com.infra.adapters.web.file.controller;

import com.infra.application.file.FileManager;
import com.infra.domain.file.FileAttributes;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
public class FileListingServiceImpl implements FileListingService {

    @Autowired
    FileManager fileManager;

    @Override
    @Operation(summary = "Get attributes of ALL files in the given directory recursively")
    @GetMapping(value="/fileservice/dirdetail", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FileAttributes>> getDirDetails(@RequestParam(name="dirName") String dir) throws Exception {
        log.info("Dir name extracted from GET request:" + dir);
        List<FileAttributes> fileList = fileManager.getDirDetails(dir);
        log.info("Count of files fetched for dir:'" + dir + "', are: " + fileList.size());
        return new ResponseEntity<List<FileAttributes>>(fileList, HttpStatus.OK);
    }
}
