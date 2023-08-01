package com.ryu2u.exercise.month7;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-07-24 10:29:49
 */
public class Test_20230723 {
    @Test
    public void test() {
        // ch2
        // ch6
        // ch11
    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = 0;
        while (l < r){
            int x = r - l;
            int y = Math.min(height[l],height[r]);
            int area = x * y;
            max = Math.max(area,max);
            if (height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;

    }

    public String convert(String s, int numRows) {
        if (numRows <= 1){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int n = 0;
        int flag = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            list.get(n).append(c);
            if (n==0||n == numRows -1){
                flag = -flag;
            }
            n += flag;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder builder : list) {
            sb.append(builder);
        }
        return sb.toString();

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode newNode = node;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2;
            if (carry > 0) {
                sum += carry;
                carry = 0;
            }
            if (sum >= 10) {
                carry = 1;
                sum %= 10;
            }
            node.next = new ListNode(sum);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            node = node.next;
        }
        if (carry > 0) {
            node.next = new ListNode(1);
        }
        return newNode.next;

    }


}