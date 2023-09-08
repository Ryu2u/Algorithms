package com.ryu2u.entity;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 树
 *
 * @author Administrator
 * @Description:
 * @date 2023/6/21 13:45
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }


    public static TreeNode arrayToTreeNode(Integer[] arr) {
        if (arr.length <= 0) {
            return null;
        }
        int l = 1;
        int r = 2;
        TreeNode root = new TreeNode(arr[0]);
        helper(arr, root, l, r);
        return root;
    }

    private static void helper(Integer[] arr, TreeNode node, int l, int r) {
        if (l > arr.length - 1) {
            return;
        }
        Integer left = arr[l];
        Integer right = null;
        if (r < arr.length) {
            right = arr[r];
        }
        if (left != null) {
            node.left = new TreeNode(left);
            helper(arr, node.left, l + 2, r + 2);
        }
        if (right != null) {
            node.right = new TreeNode(right);
            helper(arr, node.right, l + 2, r + 2);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, null, 2, 3};
        TreeNode root = TreeNode.arrayToTreeNode(arr);
        List<Integer> list = TreeNode.inorderTraversal(root);
        System.out.println(list);
    }

}
