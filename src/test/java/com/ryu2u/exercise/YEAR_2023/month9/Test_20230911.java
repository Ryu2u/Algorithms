package com.ryu2u.exercise.YEAR_2023.month9;

import com.ryu2u.entity.ListNode;
import com.ryu2u.entity.TreeNode;
import com.ryu2u.utils.ArrUtils;
import org.junit.Test;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-09-11 15:15:52
 */
public class Test_20230911 {
    @Test
    public void test() {
        // ch91
        // ch226

        Integer[] arr = {};
        TreeNode treeNode = TreeNode.arrayToTreeNode(arr);
        TreeNode treeNode1 = invertTree(treeNode);
        // ch344

    }

    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char cl = s[l];
            char cr = s[r];
            s[l] = cr;
            s[r] = cl;
            l++;
            r--;
        }

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


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0, head);
        ListNode newNode = node;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        while (head != null) {
            node = node.next;
            head = head.next;
        }
        node.next = node.next.next;
        return newNode.next;
    }


}