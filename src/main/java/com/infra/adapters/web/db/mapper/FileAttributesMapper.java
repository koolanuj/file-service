package com.infra.adapters.web.db.mapper;

import com.infra.adapters.util.Util;
import com.infra.domain.file.FileAttributes;
import com.infra.domain.file.jpa.JpaFileAttributes;
import org.springframework.stereotype.Component;

@Component
public class FileAttributesMapper implements Mapper<JpaFileAttributes, FileAttributes> {

    @Override
    public JpaFileAttributes map(FileAttributes source) {
        JpaFileAttributes target = new JpaFileAttributes();
        target.setName(source.getName());
        target.setPath(source.getPath());
        target.setSize(source.getSize());
        target.setFileType(source.getFileType());
        target.setLastModifiedTime(source.getLastModifiedTime());
        target.setAccessTime(source.getAccessTime());
        target.setCreationTime(source.getCreationTime());

//        target.setLastModifiedTime(Util.convertStrToDateTime(source.getLastModifiedTime()));
//        target.setAccessTime(Util.convertStrToDateTime(source.getAccessTime()));
//        target.setCreationTime(Util.convertStrToDateTime(source.getCreationTime()));
        return target;
    }

    @Override
    public FileAttributes map(JpaFileAttributes source) {
        FileAttributes target = new FileAttributes();
        target.setName(source.getName());
        target.setPath(source.getPath());
        target.setSize(source.getSize());
        target.setFileType(source.getFileType());
        target.setLastModifiedTime(source.getLastModifiedTime().toString());
        target.setAccessTime(source.getAccessTime().toString());
        target.setCreationTime(source.getCreationTime().toString());
        return target;
    }

}
