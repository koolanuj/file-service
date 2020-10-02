INSERT INTO file.File_Attribute(Name, Path, Size, `FileType`, `AccessTime`, `CreationTime`, `LastModifiedTime`) VALUES ('sample-file', '/var/tmp/', 122, 'regular', now(), now(), now());

INSERT INTO file.File_Attribute(Name, Path, Size, `FileType`, `AccessTime`, `CreationTime`, `LastModifiedTime`) VALUES ('file2', '/tmp/', 459864, 'regular', now(), now(), now());

SELECT * FROM file.File_Attribute
