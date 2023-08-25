package com.ryu2u.exercise.month8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-08-25 08:52:07
 */
public class Test_20230824 {
    @Test
    public void test() {
        // ch46
        String s1 = "mississippi";
        String s2 = "issip";
        System.out.println(strStr(s1, s2));
        System.out.println(s1.indexOf(s2));

    }

    /**
     * KMP
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int[] next = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && p[i] != p[j]) {
                j = next[j - 1];
            }
            if (p[i] == p[j]){
                j++;
            }
            next[i] = j;
        }
        for (int i = 0,j=0; i < n; i++) {
            while(j > 0 && s[i] != p[j]){
                j = next[j-1];
            }
            if (s[i] == p[j]){
                j++;
            }
            if (j == m){
                return i - m + 1;
            }
        }
        return -1;

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTracking(list, nums, used);
        return list;
    }

    List<Integer> temp = new ArrayList<>();

    private void backTracking(List<List<Integer>> list, int[] arr, boolean[] used) {
        if (temp.size() == arr.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                temp.add(arr[i]);
                used[i] = true;
                backTracking(list, arr, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }

    }


}