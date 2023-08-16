package com.ryu2u.medium;

import org.junit.Test;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * <p>
 * 提示：
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 *
 * @author Administrator
 * @Description:
 * @date 2023/8/16 17:17
 */
public class ch55_跳跃游戏 {
    @Test
    public void test() {
        int[] nums = {1,2,3};
        System.out.println(canJump(nums));
    }


    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int i = 0;
        while (i < nums.length) {
            int n = nums[i];
            int x = i;
            int max = 0;
            if (i + n >= nums.length - 1) {
                return true;
            }
            for (int j = i + 1; j <= i + n; j++) {
                int y = nums[j];
                if (max <= j + y) {
                    max = j + y;
                    x = j;
                }
            }
            i = x;
            if (max == 0) {
                return false;
            }
        }
        return true;
    }

}
