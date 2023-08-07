package com.ryu2u.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 * @author Administrator
 * @Description:
 * @date 2023/8/7 17:31
 */
public class ch47_全排列II {
    @Test
    public void test() {
        int[] nums = {1,1,2,1,1,1,1,1};
        System.out.println(permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(list, nums, used);
        return list;
    }

    List<Integer> temp = new ArrayList<>();

    private void backTracking(List<List<Integer>> list, int[] arr, boolean[] used) {
        if (temp.size() == arr.length) {
            System.out.println(Arrays.toString(used));
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i-1] && !used[i-1]){
                continue;
            }
            if (!used[i]){
                temp.add(arr[i]);
                used[i] = true;
                backTracking(list, arr, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
