package com.ryu2u.easy;

import com.ryu2u.entity.TreeNode;

/**
 *给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * @author Administrator
 * @Description:
 * @date 2023/6/27 9:31
 */
public class ch101_对称二叉树 {

    public static boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left,root.right);
    }

    /**
     * 与相同的树那题的区别:
     *  这一题是判断
     *  左边的树的右子树和右边的树的左子树
     *  以及
     *  左边的树的左子树和右边的树的右子树
     *
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null && q==null){
            return true;
        }else if(p==null || q==null){
            return false;
        }else if(p.val != q.val){
            return false;
        }else{
            return isSameTree(p.left,q.right) && isSameTree(p.right,q.left);
        }

    }


}
