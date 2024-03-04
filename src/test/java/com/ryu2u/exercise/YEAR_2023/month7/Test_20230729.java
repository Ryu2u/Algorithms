package com.ryu2u.exercise.YEAR_2023.month7;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-07-29 17:19:36
 */
public class Test_20230729 {
    @Test
    public void test() {
        // ch17
        //ch2
        // ch300
        // ch5

    }

    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int begin = 0;
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                int l = i - j + 1;
                if (l > s.length()) {
                    break;
                }
                if (s.charAt(j) != s.charAt(i)) {
                    dp[j][i] = false;
                } else if (l <= 3) {
                    dp[j][i] = true;
                } else {
                    dp[j][i] = dp[j + 1][i - 1];
                }
                if (dp[j][i] && l > max) {
                    max = l;
                    begin = j;
                }
            }
        }
        return s.substring(begin,begin + max);
    }

    public int lengthOfLIS(int[] nums) {
        int[] f = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, f[i]);
        }
        return ans;
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
                carry = sum / 10;
                sum %= 10;
            }
            node.next = new ListNode(sum);
            node = node.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            node.next = new ListNode(1);
        }

        return newNode.next;

    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if ("".equals(digits)) {
            return list;
        }
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(list, letters, digits, 0);
        return list;
    }

    StringBuilder sb = new StringBuilder();

    private void backTracking(List<String> list, String[] letters, String digits, int num) {
        if (digits.length() == num) {
            list.add(sb.toString());
            return;
        }
        String str = letters[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backTracking(list, letters, digits, num + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }


}