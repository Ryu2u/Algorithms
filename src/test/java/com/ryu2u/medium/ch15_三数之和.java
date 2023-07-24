package com.ryu2u.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * <p>
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * <p>
 * <p>
 * 提示：
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * @author Administrator
 * @Description:
 * @date 2023/7/24 13:49
 */
public class ch15_三数之和 {

    @Test
    public void test() {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        quickSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                break;
            }
            if (i>0&&nums[i] == nums[i-1]){
                continue;
            }
            int l = i +1;
            int r = nums.length-1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum==0){
                    list.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l<r && nums[l] == nums[l + 1]){
                        l++;
                    }
                    while(l<r && nums[r] == nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                }else if (sum > 0){
                    r--;
                }else {
                    l++;
                }
            }
        }
        return list;

    }

    private void quickSort(int[] arr ,int low,int high){
        if (low >= high){
            return;
        }
        int l = low;
        int r = high;
        int k = arr[l];
        while(l < r){
            while(l < r && arr[r] >= k){
                r--;
            }
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            while(l < r && arr[l] <= k){
                l++;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
        quickSort(arr,l + 1,high);
        quickSort(arr,low,r-1);
    }


}
