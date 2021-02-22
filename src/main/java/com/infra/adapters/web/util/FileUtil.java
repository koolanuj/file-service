<<<<<<< Updated upstream:src/main/java/com/infra/adapters/web/util/FileUtil.java
package com.infra.adapters.web.util;

/**
 * Utlity class for Error handling
 */
public class FileUtil {

    private static String usageStr;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("This application provides following REST APIs to fetch file attributes. Sample calls (in local environment): <br>")
                .append("To get attributes of a file: <br>")
                .append("http://localhost:8080/fileservice/filedetail?fileName=C:/Program Files/file-name  <br/><br/>")
                .append("2) To get attributes of ALL files in a directory recursively: <br/>")
                .append("http://localhost:8080/fileservice/dirdetail?dirName=C:/Program%20Files")
                .append("<br/><br/>");
        usageStr = sb.toString();
    }

    public static String getUsageStr(){
        return usageStr;
    }
}
=======
package com.infra.adapters.util;

/**
 * Utlity class for Error handling
 */
public class FileErrorUtil {

    private static String usageStr;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("This application provides following REST APIs to fetch file attributes. Sample calls (in local environment): <br>")
                .append("To get attributes of a file: <br>")
                .append("http://localhost:8080/fileservice/filedetail?fileName=C:/Program Files/file-name  <br/><br/>")
                .append("2) To get attributes of ALL files in a directory recursively: <br/>")
                .append("http://localhost:8080/fileservice/dirdetail?dirName=C:/Program%20Files")
                .append("<br/><br/>");
        usageStr = sb.toString();
    }

    public static String getUsageStr(){
        return usageStr;
    }
}
>>>>>>> Stashed changes:src/main/java/com/infra/adapters/util/FileErrorUtil.java
