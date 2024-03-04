package com.ryu2u.exercise.YEAR_2023.month9;

import com.ryu2u.entity.TreeNode;
import com.ryu2u.utils.ArrUtils;
import org.junit.Test;

import java.util.*;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-09-08 10:13:46
 */
public class Test_20230910 {
    @Test
    public void test() {
        // ch231
        // ch144
        // ch56
        int[][] arr = ArrUtils.stringArrToMatrixArr("[[1,4],[0,2],[3,5]]");
        int[][] merge = merge(arr);
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }

    }

    public int[][] merge(int[][] intervals) {
        int m = intervals.length;
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(intervals[0][0]);
        temp.add(intervals[0][1]);
        list.add(temp);
        for (int i = 1; i < m; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (l <= list.get(list.size() - 1).get(1)) {
                list.get(list.size() - 1).set(0, Math.min(list.get(list.size() - 1).get(0), l));
                list.get(list.size() - 1).set(1, Math.max(list.get(list.size() - 1).get(1), r));
            } else {
                List<Integer> ll = new ArrayList<>();
                ll.add(l);
                ll.add(r);
                list.add(ll);
            }
        }
        int[][] arr = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> l = list.get(i);
            int[] ints = l.stream().mapToInt(Integer::intValue).toArray();
            arr[i] = ints;
        }
        return arr;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return list;
    }

    private void preorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(list, root.left);
        preorder(list, root.right);
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }


}