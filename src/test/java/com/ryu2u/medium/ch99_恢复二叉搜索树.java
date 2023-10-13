package com.ryu2u.medium;

import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 * <p>
 * 示例 1：
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 * <p>
 * 示例 2：
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 * <p>
 * 提示：
 * 树上节点的数目在范围 [2, 1000] 内
 * -231 <= Node.val <= 231 - 1
 * <p>
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？*
 *
 * @author Administrator
 * @Description:
 * @date 2023/10/13 16:03
 */
public class ch99_恢复二叉搜索树 {
    @Test
    public void test() {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.right.left = new TreeNode(2);
        recoverTree(node);
    }

    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        TreeNode mistake = null;
        TreeNode first = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val < pre.val) {
                first = root;
                if (mistake == null) {
                    mistake = pre;
                } else {
                    break;
                }
            }
            pre = root;
            root = root.right;
        }
        int temp = first.val;
        first.val = mistake.val;
        mistake.val = temp;
    }


}
