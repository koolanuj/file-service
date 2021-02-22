package com.infra.domain.file.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="file_attribute")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JpaFileAttributes extends JpaBaseEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Id;

    @Column(name="name")
    private String name;

    @Column(name="path")
    private String path;

    @Column(name="size")
    private long size;

    @Column(name="file_type")
    private String fileType;

    @Column(name="access_time")
    private String accessTime;

    @Column(name="creation_time")
    private String creationTime;

    @Column(name="last_modified_time")
    private String lastModifiedTime;

}
