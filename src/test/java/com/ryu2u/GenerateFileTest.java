package com.ryu2u;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 * @Description:
 * @date 2023/6/30 11:35
 */
public class GenerateFileTest {

    public static final String EASY_PATH = "D:\\Project\\Demo\\JavaDEMO\\Algorithms\\src\\test\\java\\com\\ryu2u\\easy";
    public static final String EASY_PACKAGE = "package com.ryu2u.easy;\n";
    public static final String MEDIUM_PATH = "D:\\Project\\Demo\\JavaDEMO\\Algorithms\\src\\test\\java\\com\\ryu2u\\medium";
    public static final String MEDIUM_PACKAGE = "package com.ryu2u.medium;\n";
    public static final String DIFFICULT_PATH = "D:\\Project\\Demo\\JavaDEMO\\Algorithms\\src\\test\\java\\com\\ryu2u\\difficult";
    public static final String DIFFICULT_PACKAGE = "package com.ryu2u.difficult;\n";

    private static final String LINE = "\r\n";
    private static final String TAB = "\t";

    @Test
    public void generateEasy() {
        String[] fileNames = {"ch136_只出现一次的数字", "ch141_环形链表", "ch144_二叉树的前序遍历", "ch145_二叉树的后序遍历", "ch157_用Read4读取 N个字符", "ch160_相交链表", "ch163_缺失的区间", "ch168_Excel表列名称", "ch169_多数元素", "ch170_" +
                "两数之和III_数据结构设计", "ch171_Excel表列序号", "ch175_组合两个表", "ch181_超过经理收入的员工", "ch182_查找重复的电子邮箱", "ch183_从不订购的客户", "ch190_颠倒二进制位", "ch191_位1的个数", "ch193_有效电话号码", "ch195_第十行", "ch196_删除重复的电子邮箱", "ch197_上升的温度", "ch202_快乐数"};
        for (String fileName : fileNames) {
            fileName = fileName.replace(" ", "_");
            generateFile(fileName);
        }

    }

    public static void generateFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        sb.append(EASY_PACKAGE).append(LINE);
        sb.append("/**\n" +
                        " * @author Administrator\n" +
                        " * @Description:")
                .append(LINE);
        sb.append(" * @date ");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        sb.append(date).append(LINE).append(" */").append(LINE);
        sb.append("public class ").append(fileName).append(TAB).append("{").append(LINE).append(LINE).append("}");
        String content = sb.toString();
        File file = new File(EASY_PATH + "\\" + fileName + ".java");
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
        }
    }


    @Test
    public void test() {
        System.out.println(testFinally().val);
    }

    public static ListNode testFinally() {
        ListNode listNode = new ListNode(0);
        try {
            listNode.val = 1;
            System.out.println("111");
            return listNode;
        }catch (Exception e){
            listNode.val = 2;
        }finally {
            listNode.val = 3;
            System.out.println("finally");
//            return listNode.val;
        }
            return listNode;
    }


}
