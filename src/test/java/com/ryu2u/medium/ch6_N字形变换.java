package com.ryu2u.medium;

import com.sun.jmx.snmp.SnmpUnknownMsgProcModelException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * <p>
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 * @author Administrator
 * @Description:
 * @date 2023/7/22 11:18
 */
public class ch6_N字形变换 {
    @Test
    public void test() {
        String str = "";
        int numsRows = 4;
        System.out.println(convert(str, numsRows));

    }


    /**
     * 可以知道的是如果numRows=4
     * 那么s 在list 中的索引为012321 012321
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows < 2){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            list.get(i).append(c);
            // 在边界处需要取反
            if (i == 0 || i == numRows - 1){
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder builder : list) {
            sb.append(builder);
        }
        return sb.toString();

    }

}
