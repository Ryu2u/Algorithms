package com.ryu2u.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * <p>
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 * @author Administrator
 * @Description:
 * @date 2023/9/12 17:05
 */
public class ch90_子集II {
    @Test
    public void test() {
        int[] arr = {1, 2, 2};
        List<List<Integer>> lists = subsetsWithDup(arr);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backTracking(list, nums, 0);
        return list;
    }

    List<Integer> temp = new ArrayList<>();

    private void backTracking(List<List<Integer>> list, int[] arr, int index) {
        list.add(new ArrayList<>(temp));
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
               continue;
            }
            temp.add(arr[i]);
            backTracking(list, arr, i + 1);
            temp.remove(temp.size() - 1);
        }
    }


}
