package com.ryu2u.exercise.YEAR_2023.month9;

import com.ryu2u.entity.ListNode;
import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-09-06 15:33:46
 */
public class Test_20230905 {
    @Test
    public void test() {
        //ch160
        // ch104

        // ch50
    }

    public double myPow(double x, int n) {
        long N = n;
        return N > 0 ? quickPow(x, N) : 1 / quickPow(x, -N);
    }

    private double quickPow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double v = quickPow(x, n / 2);
        return n % 2 == 0 ? v * v : v * v * x;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return maxDepth(root.right) + 1;
        } else if (root.right == null) {
            return maxDepth(root.left) + 1;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }

}