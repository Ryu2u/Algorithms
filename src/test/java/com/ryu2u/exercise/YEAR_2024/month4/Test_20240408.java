package com.ryu2u.exercise.YEAR_2024.month4;

import org.junit.Test;
import com.ryu2u.entity.TreeNode;
import com.ryu2u.entity.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2024-04-08 13:03:31
 */
public class Test_20240408 {

    @Test
    public void test0() {

    }

    // ch350
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            arr.add(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (arr.contains(nums1[i])) {
                list.add(nums1[i]);
                arr.remove((Integer) nums1[i]);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;

    }

    @Test
    public void test1() {

    }

    public boolean isHappy(int n) {

        List<Integer> list = new ArrayList<Integer>();
        while (true) {
            if (n == 1) {
                return true;
            }
            list.add(n);
            n = getNext(n);
            if (list.contains(n)) {
                return false;
            }
        }

    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int num = n % 10;
            n /= 10;
            sum = sum + num * num;
        }
        return sum;
    }

    @Test
    public void test2() {

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                Integer start = map.get(target - num);
                return new int[]{start, i};
            } else {
                map.put(num, i);
            }
        }

        return null;
    }

    @Test
    public void test3() {

    }

    // ch242
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
        }

        return Arrays.equals(arr, new int[26]);
    }

    @Test
    public void test4() {

    }

    // ch383
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int c = ransomNote.charAt(i) - 'a';
            arr[c]--;
            if (arr[c] < 0) {
                return false;
            }
        }

        return true;

    }


    // ch15
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return list;
    }


    //ch18
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                int l = j + 1;
                int r = len - 1;
                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return list;

    }


}