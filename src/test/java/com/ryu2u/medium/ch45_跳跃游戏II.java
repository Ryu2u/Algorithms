package com.ryu2u.medium;

import org.junit.Test;

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * <p>
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * <p>
 * 提示:
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 *
 * @author Ryu2u
 * @Description:
 * @date 2023/8/5 14:11
 */
public class ch45_跳跃游戏II {
    @Test
    public void test() {
        int[] nums = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0};
        System.out.println(jump(nums));

    }

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int i = 0;
        int count = 0;
        while (i < nums.length) {
            int n = nums[i];
            if (i + n >= nums.length - 1) {
                return ++count;
            }
            int max = 0;
            int k = i;
            for (int j = k + 1; j <= k + n && j < nums.length; j++) {
                if (j + nums[j] > max) {
                    max = nums[j] + j;
                    i = j;
                }
            }
            count++;
        }
        return 0;
    }


}
