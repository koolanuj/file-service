package com.infra.adapters.web.db.controller;

import com.infra.domain.file.jpa.JpaFileAttributes;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface FileDBService {

    public ResponseEntity<List<JpaFileAttributes>> getAllFileDetailsFromDB() throws Exception;

    public ResponseEntity<JpaFileAttributes> getFileDetailsByIdFromDB(Integer fileId) throws Exception;

    public ResponseEntity<JpaFileAttributes> saveFileDetails(String file) throws Exception;

    public ResponseEntity<List<JpaFileAttributes>> saveAllFileDetails(String dirName) throws Exception;
}
