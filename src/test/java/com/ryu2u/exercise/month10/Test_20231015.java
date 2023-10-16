package com.ryu2u.exercise.month10;

import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-10-15 16:34:04
 */
public class Test_20231015 {
    @Test
    public void test() {
        // ch97
        // ch96
        // ch95
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        list.add(null);
        for (int i = 1; i <= n; i++) {
            List<TreeNode> cur = new ArrayList<>();
            for (TreeNode treeNode : list) {
                TreeNode insert = new TreeNode(i);
                insert.left = copyTree(treeNode);
                cur.add(insert);
                for (int j = 0; j <= n; j++) {
                    TreeNode copyTree = copyTree(treeNode);
                    TreeNode right = copyTree;
                    for (int k = 0; k < j; k++) {
                        if (right != null) {
                            right = right.right;
                        }
                    }
                    if (right == null) {
                        break;
                    }
                    TreeNode left = right.right;
                    insert = new TreeNode(i);
                    insert.left = left;
                    right.right = insert;
                    cur.add(copyTree);
                }
            }
            list = cur;
        }
        return list;
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

    public int numTrees(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                f[i] += f[j - 1] * f[i - j];
            }
        }
        return f[n];
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        char[] cs3 = s3.toCharArray();
        boolean[][] dp = new boolean[cs1.length + 1][cs2.length + 1];
        dp[0][0] = true;
        for (int i = 1; i < cs1.length + 1; i++) {
            dp[i][0] = dp[i - 1][0] && cs1[i - 1] == cs3[i - 1];
        }

        for (int i = 1; i < cs2.length + 1; i++) {
            dp[0][i] = dp[0][i - 1] && cs2[i - 1] == cs3[i - 1];
        }
        for (int i = 1; i < cs1.length + 1; i++) {
            for (int j = 1; j < cs2.length + 1; j++) {
                dp[i][j] = (dp[i - 1][j] && cs1[i - 1] == cs3[i + j - 1]) || (dp[i][j - 1] && cs2[j - 1] == cs3[i + j - 1]);
            }
        }

        return dp[cs1.length][cs2.length];
    }


}