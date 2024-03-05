package com.ryu2u.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * <p>
 * 进阶：你能尽量减少完成的操作次数吗？
 *
 * @author Administrator
 * @Description:
 * @date 2024/3/5 10:26
 */
public class ch283_移动零 {

    @Test
    public void test() {
        int[] nums = {0,0,1,2,3,4,5,0,6,7,8,0,9,10,0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }


    public void moveZeroes(int[] nums) {
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[r] != 0) {
                nums[l++] = nums[r];
            }
            r++;
        }
        while(l < nums.length){
            nums[l++] = 0;
        }

    }

}
