package com.ryu2u.medium;

import com.ryu2u.entity.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import javax.xml.soap.Node;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * 提示：
 * 1 <= n <= 8*
 *
 * @author Administrator
 * @Description:
 * @date 2023/10/7 13:17
 */
public class ch95_不同的二叉搜索树II {
    @Test
    public void test() {
        generateTrees(3);

    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> pre = new ArrayList<>();
        pre.add(null);
        for (int i = 1; i <= n; i++) {
            List<TreeNode> cur = new ArrayList<>();
            for (TreeNode treeNode: pre) {
                TreeNode root = new TreeNode(i);
                root.left = treeNode;
                cur.add(root);
                for (int j = 0; j <= n; j++) {
                    TreeNode copyTree = copyTree(treeNode);
                    TreeNode right = copyTree;
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
                    root = new TreeNode(i);
                    right.right = root;
                    root.left = left;
                    cur.add(copyTree);
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


}
