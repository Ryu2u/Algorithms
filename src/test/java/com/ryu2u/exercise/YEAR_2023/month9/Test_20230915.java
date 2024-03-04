package com.ryu2u.exercise.YEAR_2023.month9;

import com.ryu2u.entity.ListNode;
import com.ryu2u.entity.TreeNode;
import com.ryu2u.utils.ArrUtils;
import com.sun.deploy.util.ArrayUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-09-15 13:15:51
 */
public class Test_20230915 {
    @Test
    public void test() {
        // ch57
        int[][] intervals = ArrUtils.stringArrToMatrixArr("[[1,3],[6,9]]");
        int[][] insert = insert(intervals, new int[]{2, 5});
        for (int i = 0; i < insert.length; i++) {
            System.out.println(Arrays.toString(insert[i]));
        }
        // ch112
        // ch82
        int[] arr = {1,1,1,2,2,2,3};
        ListNode head = ListNode.arrayToListNode(arr);
        ListNode listNode = deleteDuplicates(head);
        ListNode.printList(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = new ListNode();
        ListNode newNode = node;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
            } else {
                node.next = new ListNode(head.val);
                node = node.next;
            }
            head = head.next;
        }
        return newNode.next;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        backTracking(root, 0, targetSum);
        return flag;
    }

    boolean flag = false;

    private boolean backTracking(TreeNode root, int sum, int targetSum) {
        if (flag) {
            return true;
        }
        if (root == null) {
            flag = sum == targetSum;
        } else if (root.left == null && root.right == null) {
            flag = (sum + root.val) == targetSum;
        } else if (root.right == null) {
            flag = backTracking(root.left, sum + root.val, targetSum);
        } else if (root.left == null) {
            flag = backTracking(root.right, sum + root.val, targetSum);
        } else {
            flag = backTracking(root.left, sum + root.val, targetSum) || backTracking(root.right, sum + root.val, targetSum);
        }
        return flag;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] arr = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            arr[i][0] = intervals[i][0];
            arr[i][1] = intervals[i][1];
        }
        arr[intervals.length][0] = newInterval[0];
        arr[intervals.length][1] = newInterval[1];
        Arrays.sort(arr, Comparator.comparing(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int l = arr[i][0];
            int r = arr[i][1];
            if (i == 0) {
                list.add(new int[]{l, r});
            } else {
                if (l <= list.get(list.size() - 1)[1]) {
                    int[] nums = list.get(list.size() - 1);
                    nums[0] = Math.min(l, nums[0]);
                    nums[1] = Math.max(r, nums[1]);
                } else {
                    list.add(new int[]{l, r});
                }
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


}