package com.ryu2u.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 20
 * s 仅由数字组成
 *
 * @author Administrator
 * @Description:
 * @date 2023/9/22 10:30
 */
public class ch93_复原IP地址 {
    @Test
    public void test() {
        System.out.println(restoreIpAddresses("101023"));

    }

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return list;
        }
        backTracking(list, s, 0, 0);
        return list;
    }

    List<String> temp = new ArrayList<>();

    private void backTracking(List<String> list, String ip, int l, int count) {
        if (count == 4) {
            if (l != ip.length()) {
                return;
            }
            list.add(String.join(".", temp));
        }
        // 如果剩下的字符串不够或者超出了最大需要的长度,直接返回
        if (ip.length() - l < 4 - count || ip.length() - l > 3 * (4 - count)) {
            return;
        }
        // ip的每一节最大是三位数
        for (int i = 0; i < 3; i++) {
            if (l + i > ip.length() - 1) {
                break;
            }
            String ipString = getIpString(ip, l, l + i);
            if ("".equals(ipString)) {
                continue;
            }
            temp.add(ipString);
            backTracking(list, ip, l + i + 1, count + 1);
            temp.remove(temp.size() - 1);
        }
    }

    private String getIpString(String s, int l, int r) {
        String str = s.substring(l, r + 1);
        if (str.length() > 1 && str.startsWith("0")) {
            return "";
        }
        int ipNum = Integer.parseInt(str);
        if (ipNum < 0 || ipNum > 255) {
            return "";
        }
        return str;
    }

}
