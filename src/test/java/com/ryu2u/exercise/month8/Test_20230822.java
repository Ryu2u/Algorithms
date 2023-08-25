package com.ryu2u.exercise.month8;

import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-22 08:56:45
 */
public class Test_20230822 {
    @Test
    public void test() {
        // ch145
        // ch104
        // ch55
        int[] arr = {2, 3, 1, 1, 4};
        canJump(arr);

    }

    public boolean canJump(int[] nums) {
        int i = 0;
        while (i < nums.length - 1) {
            int n = nums[i];
            int max = 0;
            if (i + n >= nums.length - 1) {
                return true;
            }
            int k = i;
            for (int j = k + 1; j <= k + n; j++) {
                if (max <= j + nums[j]) {
                    max = j + nums[j];
                    i = j;
                }
            }
            if (max == 0) {
                return false;
            }
        }
        return true;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else if (root.right == null) {
            return maxDepth(root.left) + 1;
        } else if (root.left == null) {
            return maxDepth(root.right) + 1;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }

    }

    public List<Integer> postorderTraversal(TreeNode root) {
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
            if (root.right == null || pre == root.right) {
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


}