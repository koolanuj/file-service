package com.infra.adapters.mysqldb;

import com.infra.adapters.mysqldb.exception.FileAttributeDBException;
import com.infra.domain.file.jpa.JpaFileAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileAttributesPersistence {

    @Autowired
    private FileAttributesRepo fileAttributesRepo;

    public FileAttributesPersistence(FileAttributesRepo fileAttributesRepo) {
        this.fileAttributesRepo = fileAttributesRepo;
    }

    public Iterable<JpaFileAttributes> getAllFiles() {
        return fileAttributesRepo.findAll();
    }

    public JpaFileAttributes getFileById(Integer fileId) {
        return fileAttributesRepo.findById(fileId).orElseThrow(FileAttributeDBException::new);
    }

    public void save(Iterable<JpaFileAttributes> jpaFileList) {
        fileAttributesRepo.saveAll(jpaFileList);
    }
}
