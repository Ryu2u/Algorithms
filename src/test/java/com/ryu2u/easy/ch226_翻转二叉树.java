package com.ryu2u.easy;

import com.ryu2u.entity.TreeNode;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 示例 2：
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 *
 * 提示：
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * @author Administrator
 * @Description:
 * @date 2023/7/19 11:28
 */
public class ch226_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }





}
