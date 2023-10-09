package com.ryu2u.exercise.month10;

import com.ryu2u.entity.ListNode;
import com.ryu2u.utils.ArrUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-10-09 13:16:25
 */
public class Test_20231009 {
    @Test
    public void test() {
        // ch96
        // ch86
        // ch59
        int[][] ints = generateMatrix(3);
        ArrUtils.printMatrix(ints);
        // ch22
        System.out.println(generateParenthesis(4));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTracking(list, "", n, n);
        return list;
    }


    private void backTracking(List<String> list, String str, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        if (left == right) {
            backTracking(list, str + "(", left - 1, right);

        } else {
            if (left > 0) {
                backTracking(list, str + "(", left - 1, right);
            }
            backTracking(list, str + ")", left, right - 1);
        }
    }


    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = n * n;
        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = n - 1;
        n = 1;
        while (count > 0) {
            for (int i = l; i <= r && count > 0; i++) {
                matrix[t][i] = n++;
                count--;
            }
            t++;
            for (int i = t; i <= b && count > 0; i++) {
                matrix[i][r] = n++;
                count--;
            }
            r--;
            for (int i = r; i >= l && count > 0; i--) {
                matrix[b][i] = n++;
                count--;
            }
            b--;
            for (int i = b; i >= t && count > 0; i--) {
                matrix[i][l] = n++;
                count--;
            }
            l++;
        }
        return matrix;
    }

    public ListNode partition(ListNode head, int x) {
        ListNode node = new ListNode();
        ListNode newNode = node;
        ListNode l1 = head;
        while (l1 != null) {
            if (l1.val < x) {
                node.next = new ListNode(l1.val);
                node = node.next;
            }
            l1 = l1.next;
        }
        while (head != null) {
            if (head.val >= x) {
                node.next = new ListNode(head.val);
                node = node.next;
            }
            head = head.next;
        }
        return newNode.next;
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }


}