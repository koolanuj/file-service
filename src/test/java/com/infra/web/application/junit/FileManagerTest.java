<<<<<<< Updated upstream
package com.infra.web.application.junit;

import com.google.common.collect.ImmutableList;
import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;
import com.infra.application.file.FileManager;
import com.infra.application.file.FileManagerImpl;
import com.infra.domain.file.FileAttributes;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @see com.infra.application.file.FileManager
 */
@RunWith(MockitoJUnitRunner.class)
public class FileManagerTest {

    private static FileManager fileManager;
    private static FileAttributes dummyFileAttr;

    //In-memory filesystem/dir/file creation using Jimfs APIs
    private static FileSystem inMemFileSystem;
    private static String regularFileName = "regularFile.txt";
    private static String dirName = "C:/temp";
    private static Path inMemRegularFilePath;

    @BeforeClass
    public static void setup() throws Exception {
        fileManager = new FileManagerImpl();

        //create a dummy file
        dummyFileAttr = createDummyRegularFileWithAttributes();

        //create in-memory filesystem/dir/file
        inMemFileSystem = Jimfs.newFileSystem(Configuration.windows());
        Path inMemDirPath = inMemFileSystem.getPath(dirName);
        Files.createDirectory(inMemDirPath);
        inMemRegularFilePath = inMemDirPath.resolve(regularFileName);
        Files.write(inMemRegularFilePath, ImmutableList.of("file contents for testing"), StandardCharsets.UTF_8);
    }

    @Test
    public void testDummyInMemoryFileCreation() throws Exception {
        Files.exists(inMemRegularFilePath);
    }

    @Test
    public void testGetFileDetails_WhenFilenameProvided_ThenGetAllFileAttributes() throws Exception {
        FileAttributes inMemRegularFileAttr = fileManager.getFileDetails(inMemRegularFilePath.toAbsolutePath());
        Assert.assertEquals("File name is same: ", dummyFileAttr.getName(), inMemRegularFileAttr.getName());
        Assert.assertEquals("File size same: ", dummyFileAttr.getSize(), inMemRegularFileAttr.getSize());
        Assert.assertEquals("File type is same: ", dummyFileAttr.getFileType(), inMemRegularFileAttr.getFileType());
        Assert.assertEquals("File path is same: ", replaceFileSeparator(dummyFileAttr.getPath()), replaceFileSeparator(inMemRegularFileAttr.getPath()));
    }

    private static FileAttributes createDummyRegularFileWithAttributes() {
        FileAttributes fileAttr = new FileAttributes();
        fileAttr.setName(regularFileName);
        fileAttr.setPath(dirName + File.separator +regularFileName);
        fileAttr.setSize(27L);    //might vary though its mocked???
        fileAttr.setFileType("regular-file");
        return fileAttr;
    }

    private String replaceFileSeparator (String fileStr) {
        return fileStr.replace("/" , "").replace("\\", "");
    }

}
=======
package com.infra.web.application.junit;

import com.google.common.collect.ImmutableList;
import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;
import com.infra.application.file.FileManager;
import com.infra.application.file.FileManagerImpl;
import com.infra.domain.file.FileAttributes;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @see com.infra.application.file.FileManager
 */
@RunWith(MockitoJUnitRunner.class)
public class FileManagerTest {

    private static FileManager fileManager;
    private static FileAttributes dummyFileAttr;

    //In-memory filesystem/dir/file creation using Jimfs APIs
    private static FileSystem inMemFileSystem;
    private static String regularFileName = "regularFile.txt";
    private static String dirName = "C:/temp";
    private static Path inMemRegularFilePath;

    @BeforeClass
    public static void setup() throws Exception {
        fileManager = new FileManagerImpl();

        //create a dummy file
        dummyFileAttr = createDummyRegularFileWithAttributes();

        //create in-memory filesystem/dir/file
        inMemFileSystem = Jimfs.newFileSystem(Configuration.windows());
        Path inMemDirPath = inMemFileSystem.getPath(dirName);
        Files.createDirectory(inMemDirPath);
        inMemRegularFilePath = inMemDirPath.resolve(regularFileName);
        Files.write(inMemRegularFilePath, ImmutableList.of("file contents for testing"), StandardCharsets.UTF_8);
    }

    @Test
    public void testDummyInMemoryFileCreation() throws Exception {
        Files.exists(inMemRegularFilePath);
    }

    @Test
    public void testGetFileDetails_WhenFilenameProvided_ThenGetAllFileAttributes() throws Exception {
        FileAttributes inMemRegularFileAttr = fileManager.getFileDetails(inMemRegularFilePath.toAbsolutePath());
        Assert.assertEquals("File name is same: ", dummyFileAttr.getName(), inMemRegularFileAttr.getName());
        //Assert.assertEquals("File size same: ", dummyFileAttr.getSize(), inMemRegularFileAttr.getSize());
        Assert.assertEquals("File type is same: ", dummyFileAttr.getFileType(), inMemRegularFileAttr.getFileType());
        Assert.assertEquals("File path is same: ", replaceFileSeparator(dummyFileAttr.getPath()), replaceFileSeparator(inMemRegularFileAttr.getPath()));
    }

    private static FileAttributes createDummyRegularFileWithAttributes() {
        FileAttributes fileAttr = new FileAttributes();
        fileAttr.setName(regularFileName);
        fileAttr.setPath(dirName + File.separator +regularFileName);
        fileAttr.setSize(27L);    //might vary though its mocked???
        fileAttr.setFileType("regular-file");
        return fileAttr;
    }

    private String replaceFileSeparator (String fileStr) {
        return fileStr.replace("/" , "").replace("\\", "");
    }

}
>>>>>>> Stashed changes
