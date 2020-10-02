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
import java.time.LocalDateTime;

@Entity
@Table(name="fileattribute")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JpaFileAttributes extends JpaBaseEntity {

    @Id
    @Column(name="Id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Id;

    @Column(name="Name")
    private String name;

    @Column(name="Path")
    private String path;

    @Column(name="Size")
    private long size;

    @Column(name="FileType")
    private String fileType;

    @Column(name="AccessTime")
    private LocalDateTime accessTime;

    @Column(name="CreationTime")
    private LocalDateTime creationTime;

    @Column(name="LastModifiedTime")
    private LocalDateTime lastModifiedTime;

}
