package com.ryu2u.exercise.YEAR_2023.month10;

import org.junit.Test;
import com.ryu2u.entity.TreeNode;
import com.ryu2u.entity.ListNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-10-19 10:29:43
 */
public class Test_20231017 {
    @Test
    public void test() {
        //ch5
        //ch88
        int[] nums1 = {1, 2, 10, 14, 0, 0, 0, 0, 0};
        int m = 4;
        int[] nums2 = {5, 6, 7, 8, 9};
        int n = 5;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        //ch99
    }

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode first = null;
        TreeNode second = null;
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val < pre.val) {
                second = root;
                if (first == null) {
                    first = pre;
                } else {
                    break;
                }
            }
            pre = root;
            root = root.right;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int i = m + n - 1;
        m--;
        n--;
        while (n >= 0) {
            if (m >= 0 && nums1[m] > nums2[n]) {
                int temp = nums1[i];
                nums1[i] = nums1[m];
                nums1[m] = temp;
                m--;
            } else {
                nums1[i] = nums2[n];
                n--;
            }
            i--;
        }
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int k = arr[low];
        int l = low;
        int r = high;
        while (l < r) {
            while (l < r && arr[r] >= k) {
                r--;
            }
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            while (l < r && arr[l] <= k) {
                l++;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
        quickSort(arr, l + 1, high);
        quickSort(arr, low, r - 1);
    }

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = true;
            }
        }
        int max = 1;
        int begin = 0;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[j][i] = false;
                } else if (i - j < 3) {
                    dp[j][i] = true;
                } else {
                    dp[j][i] = dp[j + 1][i - 1];
                }
                if (dp[j][i] && max < i - j + 1) {
                    max = i - j + 1;
                    begin = j;
                }
            }
        }
        return s.substring(begin, begin + max);
    }


}