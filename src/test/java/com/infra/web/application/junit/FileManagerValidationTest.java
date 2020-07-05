package com.infra.web.application.junit;

import com.infra.application.file.FileManager;
import com.infra.application.file.FileManagerImpl;
import com.infra.application.file.exceptions.InvalidFileException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Mostly for validation, negative testcases
 */
@RunWith(JUnit4.class)
public class FileManagerValidationTest {

    private static FileManager fileManager;

    @BeforeClass
    public static void setup() {
        fileManager = new FileManagerImpl();
    }

    @Test(expected = InvalidFileException.class)
    public void testHandleValidation_WhenFileNameNull_ThenThrowInvalidFileException() throws Exception {
        fileManager.handleValidation(null);
    }

    @Test(expected = InvalidFileException.class)
    public void testHandleValidation_WhenFileNameBlank_ThenThrowInvalidFileException() throws Exception {
        fileManager.handleValidation("");
    }

}
