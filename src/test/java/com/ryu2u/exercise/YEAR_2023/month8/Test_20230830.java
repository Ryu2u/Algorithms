package com.ryu2u.exercise.YEAR_2023.month8;

import com.ryu2u.entity.ListNode;
import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-30 15:54:32
 */
public class Test_20230830 {
    @Test
    public void test() {
        // ch226
        // ch203
        // ch231
        // ch54

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int t = 0;
        int b = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;
        int c = matrix.length * matrix[0].length;
        List<Integer> list = new ArrayList<>();
        while (c >= 1) {
            for (int i = l; i <= r && c >= 1; i++) {
                list.add(matrix[t][i]);
                c--;
            }
            t++;
            for (int i = t; i <= b && c >= 1; i++) {
                list.add(matrix[i][r]);
                c--;
            }
            r--;
            for (int i = r; i >= l && c >= 1; i--) {
                list.add(matrix[b][i]);
                c--;
            }
            b--;
            for (int i = b; i >= t && c >= 1; i--) {
                list.add(matrix[i][l]);
                c--;
            }
            l++;
        }
        return list;
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }


    public ListNode removeElements(ListNode head, int val) {
        ListNode newNode = new ListNode(0, head);
        ListNode node = newNode;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return newNode.next;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.left = r;
        root.right = l;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


}