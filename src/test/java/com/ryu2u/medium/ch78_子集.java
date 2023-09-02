package com.ryu2u.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 * @author Administrator
 * @Description:
 * @date 2023/9/2 13:32
 */
public class ch78_子集 {

    @Test
    public void test() {
        int[] arr = {1, 2, 3};
        System.out.println(subsets(arr));

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backTracking(list, nums, 0);
        return list;
    }

    List<Integer> temp = new ArrayList<>();

    private void backTracking(List<List<Integer>> list, int[] arr, int index) {
        list.add(new ArrayList<>(temp));
        System.out.println(index);
        for (int i = index; i < arr.length; i++) {
            temp.add(arr[i]);
            backTracking(list, arr, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}
