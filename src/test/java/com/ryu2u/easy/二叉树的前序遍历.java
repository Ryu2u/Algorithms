package com.ryu2u.easy;

import com.ryu2u.entity.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 *
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 示例 5：
 *
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * @author Administrator
 * @Description:
 * @date 2023/6/21 14:26
 */
public class 二叉树的前序遍历 {
    /**
     * 递归法
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root,list);
        return list;
    }
    public static void preorder(TreeNode node,List<Integer> list){
        if(node == null){
            return;
        }
        list.add(node.val);
        preorder(node.left,list);
        preorder(node.right,list);
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        if (root ==null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right!= null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return res;

    }

    public static void main(String[] args) {

    }

}
