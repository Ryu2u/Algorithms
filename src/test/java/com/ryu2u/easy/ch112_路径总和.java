package com.ryu2u.easy;

import com.ryu2u.entity.TreeNode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 *
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 *
 * 示例 3：
 * 输入：root = [], targetSum = 0
 * 输出：false
 * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 *
 * 提示：
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 *
 * @author Administrator
 * @Description:
 * @date 2023/6/30 11:30
 */
public class ch112_路径总和 {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
//        Set<Integer> set = new HashSet<>();
//        traverseLeafNodes(root,0,set);
//        return set.contains(targetSum);
        return traverseLeaf(root,0,targetSum);
    }

    public static void traverseLeafNodes(TreeNode node,int sum, Set<Integer> set){
        if (node ==null){
            return;
        }
        sum += node.val;
        if (node.left == null && node.right == null){
            set.add(sum);
            return;
        }
        traverseLeafNodes(node.left,sum,set);
        traverseLeafNodes(node.right,sum,set);
    }

    public static boolean traverseLeaf(TreeNode node,int sum,int targetSum){
        if (node == null){
            return false;
        }
        sum += node.val;
        if (node.left == null && node.right == null){
            return sum == targetSum;
        }
        return traverseLeaf(node.left,sum,targetSum) || traverseLeaf(node.right,sum,targetSum);
    }


    /**
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        targetSum -= root.val;
        if(root.left == null && root.right == null){
            return targetSum == 0;
        }
        return hasPathSum2(root.left,targetSum ) || hasPathSum2(root.right,targetSum);

    }

}
