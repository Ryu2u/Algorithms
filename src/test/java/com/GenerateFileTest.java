package com;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static com.ryu2u.GenerateFile.*;

/**
 * @author Administrator
 * @Description:
 * @date 2023/6/30 11:35
 */
public class GenerateFileTest {



    @Test
    public void generateExerciseFile() throws IOException {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime dateTime = LocalDateTime.now();
        int monthValue = dateTime.getMonthValue();
        int year = dateTime.getYear();
        EXERCISE_PATH += "YEAR_" + year + "\\";
        EXERCISE_PATH += "month" + monthValue;
        String monthPath = getPath() + EXERCISE_PATH;
        File monthFile = new File(monthPath);
        if (!monthFile.exists()) {
            boolean mkdir = monthFile.mkdirs();
            if (!mkdir) {
                System.err.println("文件夹[" + monthPath + "]创建失败");
                return;
            }
        }
        EXERCISE_PACKAGE += "YEAR_" + year + "." + "month" + monthValue + ";";
        String date = dateTime.format(sdf);
        String fileName = "Test_" + date;
        String filePath = getPath() + EXERCISE_PATH + "\\" + fileName;
        generateFile(filePath, fileName, EXERCISE_PACKAGE);
    }


}
