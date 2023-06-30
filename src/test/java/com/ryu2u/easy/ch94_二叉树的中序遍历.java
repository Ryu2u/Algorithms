package com.ryu2u.easy;

import com.ryu2u.entity.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 *
 *
 * @author Administrator
 * @Description:
 * @date 2023/6/21 13:44
 */
public class ch94_二叉树的中序遍历 {
    /**
     * 递归法
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        middle(root,list);
        return list;
    }

    public static void middle(TreeNode node,List<Integer> list){
        if(node == null){
            return;
        }
        middle(node.left,list);
        list.add(node.val);
        middle(node.right,list);
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        List<Integer> integers = inorderTraversal2(root);
        System.out.println(integers);

    }

}
