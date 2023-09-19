package com.ryu2u;

import org.junit.Test;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        EXERCISE_PATH += "month" + monthValue;
        EXERCISE_PACKAGE += "month" + monthValue + ";";
        String date = dateTime.format(sdf);
        String fileName = "Test_" + date;
        String filePath = getPath() + EXERCISE_PATH + "\\" + fileName;
        generateFile(filePath, fileName, EXERCISE_PACKAGE);
    }


}
