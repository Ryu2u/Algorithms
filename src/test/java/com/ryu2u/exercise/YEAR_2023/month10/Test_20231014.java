package com.ryu2u.exercise.YEAR_2023.month10;

import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-10-15 16:34:17
 */
public class Test_20231014 {
    @Test
    public void test() {
        // ch47
        // ch99
        // ch98
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        Integer pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val < pre.val) {
                second = root;
                if (first == null) {
                    first = pre;
                } else {
                    break;
                }
            }
            pre = root;
            root = root.right;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTracking(list, nums, used);
        return list;
    }

    List<Integer> temp = new ArrayList<>();

    private void backTracking(List<List<Integer>> list, int[] arr, boolean[] used) {
        if (temp.size() == arr.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1] && used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                temp.add(arr[i]);
                backTracking(list, arr, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

}