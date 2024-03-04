package com.ryu2u.exercise.YEAR_2023.month9;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-09-08 10:13:36
 */
public class Test_20230909 {
    @Test
    public void test() {
        // ch92
        // ch19
        // ch63

    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] pb = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                pb[i][0] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                pb[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    pb[i][j] = 0;
                } else {
                    pb[i][j] = pb[i][j - 1] + pb[i - 1][j];
                }
            }
        }
        return pb[m - 1][n - 1];
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = node;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return node.next;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = new ListNode(0, head);
        head = node;
        for (int i = 0; i < left - 1; i++) {
            head = head.next;
        }
        ListNode cur = head.next;
        ListNode next = null;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = head.next;
            head.next = next;
        }
        return node.next;
    }


}