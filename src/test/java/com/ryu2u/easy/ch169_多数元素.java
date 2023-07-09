package com.ryu2u.easy;

import java.util.HashMap;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * @author Administrator
 * @Description:
 * @date 2023-06-30 13:28:51
 */
public class ch169_多数元素	{
    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = -1;
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer count = map.getOrDefault(num, 0);
            count++;
            map.put(num,count);
            if (count > max){
                max = count;
                maxNum = num;
            }
        }

        return maxNum;
    }

    /**
     * 最优解
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int key = nums[0];
        int times = 1;
        // 使用投票法，从第一个数字开始，如果数字相同就time++;
        // 数字不同time--,当times等于0时，说明其他数字比较多，
        // 则将key替换为当前数字
        // 由于key的数量大于n/2所以大概率最后key 的值为最多的那个
        for (int i = 1; i < nums.length; i++) {
            if (key == nums[i]){
                times++;
            }else{
                if (times == 0){
                    key = nums[i];
                }else{
                    times--;
                }
            }
        }
        return key;
    }



    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,3,4}));
    }


}