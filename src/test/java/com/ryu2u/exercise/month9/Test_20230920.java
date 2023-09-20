package com.ryu2u.exercise.month9;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-09-20 19:43:41
 */
public class Test_20230920 {
    @Test
    public void test() {
        // ch343
        System.out.println(cuttingRope(11));
        // ch49
        // ch92

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = new ListNode(0, head);
        head = node;
        for (int i = 0; i < left - 1; i++) {
            head = head.next;
        }
        ListNode pre = head.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = pre.next;
            pre.next = next.next;
            next.next = head.next;
            head.next = next;
        }
        return node.next;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            if (!map.containsKey(String.valueOf(cs))) {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(String.valueOf(cs), temp);
            } else {
                map.get(String.valueOf(cs)).add(strs[i]);
            }
        }
        for (String str :
                map.keySet()) {
            list.add(map.get(str));
        }

        return list;
    }

    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int i = n / 3;
        int a = n % 3;
        if (a == 2) {
            return (int) Math.pow(3, i) * 2;
        } else if (a == 1) {
            return (int) Math.pow(3, i - 1) * 4;
        } else {
            return (int) Math.pow(3, i);
        }
    }


}