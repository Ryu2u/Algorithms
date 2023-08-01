package com.ryu2u.medium;

import org.junit.Test;

import java.util.Arrays;


/**
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * <p>
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * <p>
 * 示例 3：
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * <p>
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 * @author Administrator
 * @Description:
 * @date 2023/8/1 11:24
 */
public class ch31_下一个排列 {

    @Test
    public void test() {
        int[] nums = {2, 6, 3, 5, 4, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }

    /**
     * 首先找出下一个数字刚好比他大的位置i
     * 然后从后至 i 出找刚好比他大的数字，交换
     * 然后从 i 位置后一位开始到结尾反转数组
     * 由于第一步，所以我们交换完成后，i后面一定是降序的,所以反转后，就是下一个排列
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int i = nums.length - 1;
        int j = nums.length - 2;
        int k = nums.length - 1;
        while (j >= 0 && nums[j] >= nums[i]) {
            j--;
            i--;
        }
        if (j >= 0) {
            while (k > 0 && nums[j] >= nums[k]) {
                k--;
            }
            int temp = nums[j];
            nums[j] = nums[k];
            nums[k] = temp;
        }
        int n = nums.length - 1;
        while (i <= n) {
            int temp = nums[i];
            nums[i] = nums[n];
            nums[n] = temp;
            i++;
            n--;
        }

    }


}
