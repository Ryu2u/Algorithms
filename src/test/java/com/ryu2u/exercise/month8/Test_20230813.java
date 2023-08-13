package com.ryu2u.exercise.month8;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-13 16:29:26
 */
public class Test_20230813 {
    @Test
    public void test() {
        // ch3
        // ch33
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));
        // ch34

    }

    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                int left = mid;
                int right = mid;
                while (left > 0 && nums[left - 1] == target) {
                    left--;
                }
                while (right < nums.length - 1 && nums[right + 1] == target) {
                    right++;
                }
                return new int[]{left,right};
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[l] <= nums[r]) {
                // 有序
                if (target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // 旋转
                if (nums[l] <= nums[mid]) {
                    if (target >= nums[l] && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else if (nums[mid] <= nums[r]) {
                    if (target > nums[mid] && target <= nums[r]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
        }
        return -1;


    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(map.get(c) + 1, left);
            }
            map.put(c, i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }


}