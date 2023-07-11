package com.ryu2u.medium;

import java.util.Arrays;

/**
 *给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 *
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 *
 * 提示：
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * 进阶：
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 *
 * @author Administrator
 * @Description:
 * @date 2023/7/11 15:54
 */
public class ch300_最长递增子序列 {
    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums));
    }

    /**
     * 动态规划 f(x) 表示到x的最大递增子序列
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int[] f = new int[nums.length];
        Arrays.fill(f, 1);
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            for (int j = 0; j <= i; j++) {
                int y = nums[j];
                if (x > y){
                    f[i] = Math.max(f[i],f[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < f.length; i++) {
            ans = Math.max(ans,f[i]);
        }
        return ans;
    }

}
