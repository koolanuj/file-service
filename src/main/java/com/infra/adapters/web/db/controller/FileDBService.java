package com.infra.adapters.web.db.controller;

import com.infra.domain.file.FileAttributes;
import com.infra.domain.file.jpa.JpaFileAttributes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface FileDBService {

    public ResponseEntity<List<JpaFileAttributes>> getAllFileDetailsFromDB() throws Exception;

    public ResponseEntity<JpaFileAttributes> getFileDetailsByIdFromDB(Integer fileId) throws Exception;

    public ResponseEntity<List<JpaFileAttributes>> getFilesOfDirAndPersist(String dirName) throws Exception;
}
