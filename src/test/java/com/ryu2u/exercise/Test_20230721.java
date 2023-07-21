package com.ryu2u.exercise;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

/**
 * @author Administrator
 * @Description:
 * @date 2023-07-21 17:30:01
 */
public class Test_20230721 {
    @Test
    public void test() {
        // ch5
        String str = "ac";
        System.out.println(longestPalindrome(str));
        // ch21
        // ch300
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));


    }

    public int lengthOfLIS(int[] nums) {
        int[] f = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    f[i] = Math.max(f[i],f[j] +1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans,f[i]);
        }
        return ans;


    }

    @Test
    public void test11() {

    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            if (list1.val <= list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }

    }

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int begin = 0;
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                int r = i - j + 1;
                if (r > s.length()) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[j][i] = false;
                } else if (r <= 3) {
                    dp[j][i] = true;
                } else {
                    dp[j][i] = dp[j + 1][i - 1];
                }
                if (dp[j][i] && r > max) {
                    max = r;
                    begin = j;
                }
            }
        }
        return s.substring(begin, begin + max);

    }


}