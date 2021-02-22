DROP TABLE IF EXISTS file_attribute;

CREATE TABLE filestoredb.file_attribute (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100),
    path VARCHAR(500),
    size LONG,
    file_type VARCHAR(20),
    access_time VARCHAR(50),
    creation_time VARCHAR(50),
    last_modified_time VARCHAR(50),
    PRIMARY KEY (Id)
);

