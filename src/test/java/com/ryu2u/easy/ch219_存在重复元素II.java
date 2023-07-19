package com.ryu2u.easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 *
 * @author Administrator
 * @Description:
 * @date 2023/7/19 10:36
 */
public class ch219_存在重复元素II {

    @Test
    public void test() {
        int[] nums = {6,4,2,123,6,7,23,0};
        System.out.println(Arrays.toString(nums));

    }

    /**
     * Hash表
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // key: num value: index
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    private static void qSort(int[] nums,int low,int high){
        if (low >= high){
            return;
        }
        int l = low;
        int r = high;
        int k = nums[low];
        while(l < r){
            while(l < r && nums[r] >= k){
                r--;
            }
            int temp;
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            while(l < r && nums[l] <= k){
                l++;
            }
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
        qSort(nums,l+1,high);
        qSort(nums,low,r-1);
    }

}
