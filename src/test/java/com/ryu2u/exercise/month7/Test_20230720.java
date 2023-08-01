package com.ryu2u.exercise.month7;

import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author Administrator
 * @Description:
 * @date 2023-07-20 17:08:56
 */
public class Test_20230720 {
    @Test
    public void test() {
        //ch 219
        //ch13
        // ch70
        System.out.println(climbStairs(45));
        // ch111
        // ch69
        System.out.println(mySqrt(100));
    }

    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int k = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x){
                k = mid;
                l = mid + 1;
            }else{
                r = mid-1;
            }
        }
        return k;

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }

    }

    public int climbStairs(int n) {
        int pre = 0;
        int cur = 0;
        int res = 1;
        for (int i = 1; i <= n; i++) {
            pre = cur;
            cur = res;
            res = cur + pre;
        }
        return res;
    }


    private static final HashMap<Character, Integer> roman = new HashMap<Character, Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public int romanToInt(String s) {
        int sum = 0;
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            if (i + 1 < len && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                sum -= roman.get(s.charAt(i));
            } else {
                sum += roman.get(s.charAt(i));
            }
        }
        return sum;

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }

        }
        return false;


    }


}