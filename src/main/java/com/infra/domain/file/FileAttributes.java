<<<<<<< Updated upstream
package com.infra.domain.file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

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
    @NotBlank
    private String name;
    
    private String path;
    private long size;
    private String fileType;
    private String accessTime;
    private String creationTime;
    private String lastModifiedTime;
}
=======
package com.infra.domain.file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * Core domain object to capture of attributes of any file or directory
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class FileAttributes extends BaseEntity {
    @NotBlank
    private String name;
    
    private String path;
    private long size;
    private String fileType;
    private String accessTime;
    private String creationTime;
    private String lastModifiedTime;
}
>>>>>>> Stashed changes
