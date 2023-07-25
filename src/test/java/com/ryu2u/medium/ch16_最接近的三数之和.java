package com.ryu2u.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 *给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 *
 * 示例 1：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 示例 2：
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *
 * 提示：
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 *
 * @author Administrator
 * @Description:
 * @date 2023/7/25 18:04
 */
public class ch16_最接近的三数之和 {

    @Test
    public void test(){
        int[] nums = {-100,-98,-2,-1};
        int target = -101;
        System.out.println(threeSumClosest(nums, target));

    }


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        int abs = Math.abs(target - sum);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i +1;
            int r = nums.length-1;
            while(l<r){
                int num = nums[i] + nums[l] + nums[r];
                int count = Math.abs(target - num);
                if (count <= abs){
                    sum = num;
                    abs = count;
                }
                if (num == target){
                    break;
                }else if (num < target){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return sum;
    }


}
