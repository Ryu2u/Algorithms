package com.ryu2u.exercise.YEAR_2023.month10;

import com.ryu2u.entity.ListNode;
import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-10-08 13:45:58
 */
public class Test_20231008 {
    @Test
    public void test() {
        // ch202
        isHappy(20);
        // ch95
        System.out.println(generateTrees(4).size());
        // ch24
        ListNode listNode = ListNode.arrayToListNode(new int[]{1, 2, 3, 4});
        ListNode.printList(listNode);
        ListNode listNode1 = swapPairs(listNode);
        ListNode.printList(listNode1);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = next.next;
        next.next = head;
        head.next = swapPairs(head.next);
        return next;
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> pre = new ArrayList<>();
        pre.add(null);
        for (int i = 1; i <= n; i++) {
            List<TreeNode> cur = new ArrayList<>();
            for (TreeNode treeNode : pre) {
                TreeNode insert = new TreeNode(i);
                insert.left = copyTree(treeNode);
                cur.add(insert);
                for (int j = 0; j < i; j++) {
                    TreeNode node = copyTree(treeNode);
                    TreeNode right = node;
                    for (int k = 0; k < j; k++) {
                        if (right == null) {
                            break;
                        }
                        right = right.right;
                    }
                    if (right == null) {
                        break;
                    }
                    TreeNode left = right.right;
                    insert = new TreeNode(i);
                    right.right = insert;
                    insert.left = left;
                    cur.add(node);
                }
            }
            pre = cur;
        }
        return pre;
    }

    private TreeNode copyTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        node.left = copyTree(root.left);
        node.right = copyTree(root.right);
        return node;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new TreeSet<>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
            n = getNext(n);
        }
        return true;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int a = n % 10;
            sum += a * a;
            n /= 10;
        }
        return sum;
    }


}