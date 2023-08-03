package com.ryu2u.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 *
 * @author Administrator
 * @Description:
 * @date 2023/8/3 16:33
 */
public class ch40_组合总和II {
    @Test
    public void test() {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(arr, target));

    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        backTracking(list, candidates, target, 0);
        return list;
    }

    List<Integer> temp = new ArrayList<>();

    int sum = 0;

    private void backTracking(List<List<Integer>> list, int[] arr, int target, int index) {
        if (target < sum) {
            return;
        }
        if (target == sum) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }
            temp.add(arr[i]);
            sum += arr[i];
            backTracking(list, arr, target, i + 1);
            sum -= arr[i];
            temp.remove(temp.size() - 1);
        }

    }

}
