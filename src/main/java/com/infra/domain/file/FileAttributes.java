package com.infra.domain.file;

import lombok.*;

/**
 * Core domain object to capture of attributes of any file or directory
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class FileAttributes {

    private String name;
    private String path;
    private long size;
    private String fileType;
    private String accessTime;
    private String creationTime;
    private String lastModifiedTime;
}
