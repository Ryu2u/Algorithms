package com.ryu2u.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 * @author Administrator
 * @Description:
 * @date 2023/8/31 18:50
 */
public class ch77_组合 {
    @Test
    public void test() {
        System.out.println(combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        backTracking(list, arr, 0, k);
        return list;
    }

    List<Integer> temp = new ArrayList<>();

    private void backTracking(List<List<Integer>> list, int[] arr, int index, int k) {
        if (temp.size() == k) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            temp.add(arr[i]);
            backTracking(list, arr, i + 1, k);
            temp.remove(temp.size() - 1);
        }

    }

}
