package com.infra.adapters.web.db.controller;

import com.infra.adapters.mysqldb.FileAttributesPersistence;
import com.infra.adapters.web.db.mapper.FileAttributesMapper;
import com.infra.application.file.FileManager;
import com.infra.domain.file.FileAttributes;
import com.infra.domain.file.jpa.JpaFileAttributes;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
public class FileDBServiceImpl implements FileDBService {

    @Autowired
    FileAttributesPersistence fileAttributesPersistence;

    @Autowired
    FileManager fileManager;

    @Autowired
    FileAttributesMapper mapper;

    /**
     * @see FileDBService
     */
    @Override
    @Operation(summary = "Get details of ALL files from Database")
    @GetMapping(value="/db/filedetail/all", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<JpaFileAttributes>> getAllFileDetailsFromDB() throws Exception {
        log.debug("Getting all files from database...");
        Iterable<JpaFileAttributes> jpaFileAttributesIterable = fileAttributesPersistence.getAllFiles();
        List<JpaFileAttributes> fileList = new ArrayList<>();
        jpaFileAttributesIterable.forEach(fileList::add);
        log.info("Total files found from Database: " + fileList.size());
        return new ResponseEntity<List<JpaFileAttributes>>(fileList, HttpStatus.FOUND);
    }

    @Override
    @Operation(summary = "Get details of a specific file by Id from Database")
    @GetMapping(value="/db/filedetail", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<JpaFileAttributes> getFileDetailsByIdFromDB(@RequestParam(name="fileId") Integer fileId) throws Exception {
        log.debug("Getting file from database for Id " + fileId);
        JpaFileAttributes jpaFileAttributes = fileAttributesPersistence.getFileById(fileId);
        log.info("File found from DB: " + jpaFileAttributes);
        //TODO: if file not found then show appropriate message
        return new ResponseEntity<JpaFileAttributes>(jpaFileAttributes, HttpStatus.FOUND);
    }

    @Override
    @Operation(summary = "Persist details of a file in DB after retrieving it from filesystem")
    @GetMapping(value="/db/filedetail-persist", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<JpaFileAttributes> saveFileDetails(@RequestParam(name="fileName") String file) throws Exception {
        log.info("File name extracted from GET request:" + file);

        FileAttributes fileAttributes = fileManager.getFileDetails(file);
        log.info("Persisting file fetched from filesystem: {} ", fileAttributes);
        JpaFileAttributes jpaFileAttributes = mapper.map(fileAttributes);
        fileAttributesPersistence.save(jpaFileAttributes);
        return new ResponseEntity<JpaFileAttributes>(jpaFileAttributes, HttpStatus.CREATED);
    }

    @Override
    @Operation(summary = "Get details of ALL files in a given directory recursively and persist in MySQL DB as well")
    @GetMapping(value="/db/dirdetail-persist", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<JpaFileAttributes>> saveAllFileDetails(@RequestParam(name="dirName") String dirName) throws Exception {
        log.info("Dir name extracted from GET request:" + dirName);
        List<FileAttributes> fileList = fileManager.getDirDetails(dirName);
        log.info("Persisting files fetched from dir:'" + dirName + "'. Total file count: " + fileList.size());
        List<JpaFileAttributes> jpaFileList = mapper.mapEntitiesListToJpaEntities(fileList);
        fileAttributesPersistence.saveAll(jpaFileList);
        return new ResponseEntity<List<JpaFileAttributes>>(jpaFileList, HttpStatus.CREATED);
    }

}
