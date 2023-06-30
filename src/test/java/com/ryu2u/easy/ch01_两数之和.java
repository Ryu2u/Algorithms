package com.ryu2u.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * @author Administrator
 * @Description:
 * @date 2023/6/9 14:58
 */
public class ch01_两数之和 {

    public static void main(String[] args) {
        int[] arr = {3,2,5};
        int target = 7;
        int[] ints = twoSum(arr, target);
        System.out.println(Arrays.toString(ints));

    }

    /**
     * 暴力枚举
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums,int target){
        for (int i = 0; i <= nums.length - 2; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * 哈希表
     * 查询哈利表里是否有 target - nums[当前index] 值
     * 如果有直接从哈希表里获取下标和当前下标
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums,int target){
        HashMap<Integer,Integer> hashTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashTable.containsKey(target - nums[i])){
                return new int[]{hashTable.get(target-nums[i]),i};
            }
            hashTable.put(nums[i],i);
        }
        return null;
    }


}
