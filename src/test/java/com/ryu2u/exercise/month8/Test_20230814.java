package com.ryu2u.exercise.month8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-14 16:03:58
 */
public class Test_20230814 {
    @Test
    public void test() {
        // ch49
        // ch33
        // ch14
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));

    }

    public String longestCommonPrefix(String[] strs) {

        if (strs.length <= 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        int min = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min){
                min = strs[i].length();
            }
            if ("".equals(strs[i])){
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < min){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c){
                    return sb.toString();
                }
            }
            sb.append(c);
            i++;
        }
        return sb.toString();
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
                if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[l] <= nums[mid]){
                    if (target >= nums[l] && target<= nums[mid]){
                        r = mid-1;
                    }else{
                        l = mid+1;
                    }
                }else if (nums[mid] <= nums[r]){
                    if (target>= nums[mid] && target <= nums[r]){
                        l = mid +1;
                    }else{
                        r = mid-1;
                    }
                }
            }
        }
        return -1;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String sortStr = String.valueOf(cs);
            if (!map.containsKey(sortStr)) {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(sortStr, temp);
            } else {
                map.get(sortStr).add(str);
            }
        }
        for (String str : map.keySet()) {
            List<String> strings = map.get(str);
            list.add(strings);
        }
        return list;
    }


}