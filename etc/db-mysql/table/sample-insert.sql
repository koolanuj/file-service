INSERT INTO filestoredb.file_attribute(name, path, size, file_type, access_time, creation_time, last_modified_time) VALUES ('sample-file', '/var/tmp/', 122, 'regular', '2020-10-11T19:04:35.132Z', '2020-10-11T19:04:35.132Z', '2020-10-11T19:04:35.132Z');

INSERT INTO filestoredb.file_attribute(name, path, size, file_type, access_time, creation_time, last_modified_time) VALUES ('file2', '/tmp/', 459864, 'regular', CAST(now() AS char), CAST(now() AS char), CAST(now() AS char));

SELECT * FROM filestoredb.file_attribute;

----insert if columns are datetime
--INSERT INTO filestoredb.File_Attribute(Name, Path, Size, `FileType`, `AccessTime`, `CreationTime`, `LastModifiedTime`) VALUES ('sample-file', '/var/tmp/', 122, 'regular', now(), now(), now());

--INSERT INTO filestoredb.File_Attribute(Name, Path, Size, `FileType`, `AccessTime`, `CreationTime`, `LastModifiedTime`) VALUES ('file2', '/tmp/', 459864, 'regular', now(), now(), now());
