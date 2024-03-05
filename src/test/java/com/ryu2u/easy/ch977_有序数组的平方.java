package com.ryu2u.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10] -> [0,-1,3,-4,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * <p>
 * [-4,-1,0,3,10]
 * [-4,-1,0,3,10]
 * <p>
 * [-7,-6,-5,0,10,12,13,14]
 * [0,-6,-5,-7,10,12,13,14]
 * <p>
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * <p>
 * 提示：
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 * <p>
 * <p>
 * 进阶：
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 *
 * @author Administrator
 * @Description:
 * @date 2024/3/5 11:05
 */
public class ch977_有序数组的平方 {
    @Test
    public void test() {
        int[] nums = {-7,-3,2,3,11};
        int[] arr = sortedSquares(nums);
        System.out.println(Arrays.toString(arr));
    }

    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] arr = new int[nums.length];
        int cur = nums.length-1;
        while(l <= r){
            int nl = Math.abs(nums[l]);
            int nr = Math.abs(nums[r]);
            if (nl <= nr){
                arr[cur] = nr * nr;
                r--;
            }else{
                arr[cur] = nl * nl;
                l++;
            }
            cur--;
        }
        return arr;
    }


}
