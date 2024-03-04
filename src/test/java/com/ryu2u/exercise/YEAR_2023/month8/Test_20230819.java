package com.ryu2u.exercise.YEAR_2023.month8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-19 08:48:10
 */
public class Test_20230819 {
    @Test
    public void test() {
        //ch34
        //ch118
        System.out.println(generate(3));
        // ch17

    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() <= 0){
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking17(list, letters, 0, digits);
        return list;
    }
    StringBuilder sb = new StringBuilder();
    private void backTracking17(List<String> list, String[] letters, int count, String digits) {
        if (count == digits.length()) {
            list.add(sb.toString());
            return;
        }
        String str = letters[digits.charAt(count) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backTracking17(list, letters, count + 1, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        t.add(1);
        list.add(t);
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    temp.add(1);
                } else {
                    temp.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(temp);
        }
        return list;
    }

    private int nextInt(int x, int y) {
        if (y == 0 || x == y) {
            return 1;
        }
        return nextInt(x - 1, y - 1);
    }


    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                int x = mid;
                int y = mid;
                while (x > 0 && nums[x] == nums[x - 1]) {
                    x--;
                }
                while (y < nums.length - 1 && nums[y] == nums[y + 1]) {
                    y++;
                }
                return new int[]{x, y};
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

}