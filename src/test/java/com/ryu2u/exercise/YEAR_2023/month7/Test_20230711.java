package com.ryu2u.exercise.YEAR_2023.month7;

import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Administrator
 * @Description:
 * @date 2023/7/11 10:46
 */
public class Test_20230711 {

    @Test
    public void test(){
        // ch121
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        // ch101
        // ch1
        int[] ints = twoSum(new int[]{3,2,4}, 6);
        System.out.println(Arrays.toString(ints));
        // ch35


    }
    public static int maxProfit(int[] prices) {
        int[] pb = new int[prices.length+1];
        pb[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (min > price){
                min = price;
            }
            pb[i] = Math.max(pb[i-1],price - min);
        }
        return pb[prices.length-1];
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isSame(root.left,root.right);
    }

    public static boolean isSame(TreeNode node1,TreeNode node2){
        if (node1 == null && node2 == null){
            return true;
        }
        if (node1 == null || node2 == null){
            return false;
        }
        if (node1.val != node2.val){
            return false;
        }
        return isSame(node1.right,node2.left) && isSame(node1.left,node2.right);
    }



    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                return new int[]{map.get(target-num),i};
            }else{
                map.put(num,i);
            }
        }
        return null;
    }

    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = (l + r)/2;
            if (nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                r = mid;
            }else if(nums[mid] < target){
                l = mid;
            }
        }
        return -1;
    }


    @Test
    public void test001(){
        System.out.println(cost(15));
    }

    /**
     *
     * @param price
     * @return
     */
    public static int cost(int price){
        int[] dp = new int[price+1];
        dp[0] = 0;
        for (int i = 1; i <= price; i++) {
            int cost = 0;
            if (i-1 >= 0){
                cost = dp[i-1]+1;
            }
            if (i-5 >= 0){
                cost = Math.min(cost,dp[i-5] +1);
            }
            if (i-11>=0){
                cost = Math.min(cost,dp[i-11] +1);
            }
            dp[i] = cost;
        }
        return dp[price];

    }






}
