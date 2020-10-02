DROP TABLE file.File_Attribute;

CREATE TABLE file.File_Attribute (
    Id INT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(100),
    Path VARCHAR(500),
    Size LONG,
    FileType VARCHAR(20),
    AccessTime DATETIME,
    CreationTime DATETIME,
    LastModifiedTime DATETIME,
    PRIMARY KEY (Id)
)

