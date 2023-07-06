package com.ryu2u.easy;

import java.util.Arrays;

/**
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 * 示例 1 ：
 * 输入：nums = [2,2,1]
 * 输出：1
 *
 * 示例 2 ：
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 *
 * 示例 3 ：
 * 输入：nums = [1]
 * 输出：1
 *
 *
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * 除了某个元素只出现一次以外，其余每个元素均出现两次。
 *
 * @author Administrator
 * @Description:
 * @date 2023-06-30 13:28:33
 */
public class ch136_只出现一次的数字	{

    public static void main(String[] args) {
//        int[] nums = {2,2,1};
        int[] nums = {4,1,2,1,2,3,3,5,5,88,88};
        System.out.println(singleNumber(nums));
    }

    /**
     *  使用排序  时间复杂度O(nlogn)
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
        int n = 0;
        while(n < nums.length){
            if (n==nums.length-1){
                return nums[n];
            }
            int cur = nums[n];
            int nex = nums[n+1];
            if (nex != cur){
                return cur;
            }else{
                n+=2;
            }
        }
        return -1;
    }


    /**
     * 异或^
     * 这是因为相同的数进行异或(^)结果为0而0^任何值=任何值并且，异或满足交换律
     * 所以将所有数进行异或，最后结果一定是哪个单个的数字
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        int ans = nums[0];
        if (nums.length>1){
            for (int i = 1; i < nums.length; i++) {
                 ans = ans ^ nums[i];
            }
        }
        return ans;
    }

    public static void quickSort(int[] arr,int low,int high){
        if(low >= high){
            return;
        }
        int l = low;
        int r = high;
        int k = arr[low];
        while(l<r){
            while(arr[r] >= k && l<r ){
                r--;
            }
            int temp;
            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
            while(arr[l] <= k && l<r){
                l++;
            }
            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
        }
        quickSort(arr,l+1,high);
        quickSort(arr,low,r-1);
    }


}