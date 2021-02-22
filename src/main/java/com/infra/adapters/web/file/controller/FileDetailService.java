package com.infra.adapters.web.file.controller;

import com.infra.domain.file.FileAttributes;
import org.springframework.http.ResponseEntity;


public interface FileDetailService {

    public ResponseEntity<FileAttributes> getFileDetails(String fileName) throws Exception;
}
