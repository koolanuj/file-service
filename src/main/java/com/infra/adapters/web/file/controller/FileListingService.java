package com.infra.adapters.web.file.controller;

import com.infra.domain.file.FileAttributes;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FileListingService {

    public ResponseEntity<List<FileAttributes>> getDirDetails(String dir) throws Exception;
}
