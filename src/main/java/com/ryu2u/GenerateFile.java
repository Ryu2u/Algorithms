package com.ryu2u;

import com.ryu2u.entity.ListNode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 * @Description:
 * @date 2023/9/2 11:33
 */
public class GenerateFile {

    public static String EXERCISE_PATH = "\\src\\test\\java\\com\\ryu2u\\exercise\\";
    public static final String EASY_PATH = "\\src\\test\\java\\com\\ryu2u\\easy";
    public static final String EASY_PACKAGE = "package com.ryu2u.easy;\n";
    public static final String MEDIUM_PATH = "\\src\\test\\java\\com\\ryu2u\\medium";
    public static final String MEDIUM_PACKAGE = "package com.ryu2u.medium;\n";
    public static final String DIFFICULT_PATH = "\\src\\test\\java\\com\\ryu2u\\difficult";
    public static final String DIFFICULT_PACKAGE = "package com.ryu2u.difficult;\n";
    public static String EXERCISE_PACKAGE = "package com.ryu2u.exercise.";

    public static final String TEST_METHOD =
            "    @Test\n" +
                    "    public void test(){\n" +
                    "        \n" +
                    "    }";

    public static final String IMPORT_TEST = "import org.junit.Test;";

    public static String getPath() {
        String property = System.getProperty("user.dir");
        return property;
    }

    private static final String LINE = "\r\n";
    private static final String TAB = "\t";

    public static void generateFile(String path, String fileName, String packageName) {
        StringBuilder sb = new StringBuilder();
        sb.append(packageName).append(LINE);
        sb.append(IMPORT_TEST).append(LINE);
        sb.append("/**\n" +
                        " * @author Ryu2u\n" +
                        " * @Description:")
                .append(LINE);
        sb.append(" * @date ");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        sb.append(date).append(LINE).append(" */").append(LINE);
        sb.append("public class ")
                .append(fileName)
                .append(TAB)
                .append("{")
                .append(LINE)
                .append(TEST_METHOD)
                .append(LINE)
                .append(LINE)
                .append(LINE)
                .append("}");
        String content = sb.toString();
        File file = new File(path + ".java");
        FileOutputStream fos = null;
        if (!file.exists()) {
            try {
                fos = new FileOutputStream(file);
                byte[] bytes = content.getBytes();
                fos.write(bytes);
            } catch (IOException e) {
                e.printStackTrace();
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException ex) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("文件[" + fileName + "]已创建");
        } else {
            System.out.println("文件[" + fileName + "]已存在");
        }
    }

}