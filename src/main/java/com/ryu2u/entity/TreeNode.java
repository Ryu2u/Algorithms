package com.ryu2u.entity;

import sun.reflect.generics.tree.Tree;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树
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

    /**
     * 二叉树的中序遍历
     *
     * @param root
     * @return
     */
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

    /**
     * 二叉树的前序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return list;
    }


    /**
     * 二叉树后序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == pre) {
                list.add(root.val);
                pre = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;

    }

    public static TreeNode arrayToTreeNode(Integer[] arr) {
        if (arr.length <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        int count = 1;
        helper(arr, 1, root, count);
        return root;
    }

    private static void helper(Integer[] arr, int i, TreeNode node, int count) {
        if (i >= arr.length) {
            return;
        }
        System.out.println(arr[i]);
        System.out.println(arr[i + 1]);
        System.out.println();
        Integer l = arr[i];
        if (l != null) {
            node.left = new TreeNode(l);
            helper(arr, i + (2 * count), node.left, count + 1);

        }
        if (i + 1 >= arr.length) {
            return;
        }
        Integer r = arr[i + 1];
        if (r != null) {
            node.right = new TreeNode(r);
            helper(arr, i + 1 + (2 * count), node.right, count + 1);
        }
    }

    /**
     * 1 -> i+2   i+1+ 3
     * 2 ->
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 6, 3, null, 7, 9, 4, 5, null, 8, null, null};
        TreeNode root = TreeNode.arrayToTreeNode(arr);
        List<Integer> in = TreeNode.inorderTraversal(root);
        List<Integer> pre = TreeNode.preorderTraversal(root);
        List<Integer> post = TreeNode.postorderTraversal(root);
        System.out.println(in);
        System.out.println(pre);
        System.out.println(post);
    }

}
