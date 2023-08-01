package com.ryu2u.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * <p>
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 * @author Administrator
 * @Description:
 * @date 2023/8/1 14:36
 */
public class ch34_在排序数组中查找元素的第一个和最后一个位置 {
    @Test
    public void test() {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] ints = searchRange(nums, target);
        System.out.println(Arrays.toString(ints));

    }

    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int min = nums.length;
        int max = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                min = Math.min(min, mid);
                max = Math.max(max, mid);
                int x = mid;
                while (mid >= 0 && nums[mid] == target) {
                    min = Math.min(min, mid);
                    max = Math.max(max, mid);
                    mid--;
                }
                while (x < nums.length && nums[x] == target) {
                    min = Math.min(min, x);
                    max = Math.max(max, x);
                    x++;
                }
                break;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (max == -1){
            return new int[]{-1,-1};
        }else{
            return new int[]{min,max};
        }

    }

}
