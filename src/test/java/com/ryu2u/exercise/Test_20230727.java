package com.ryu2u.exercise;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-07-27 17:06:44
 */
public class Test_20230727	{
    @Test
    public void test(){
        // ch17
        System.out.println(letterCombinations("23"));
        //ch11
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
        // ch5
        String str = "1";
        System.out.println(longestPalindrome(str));

    }

    public String longestPalindrome(String s) {
        if (s.length() <= 1){
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLen = 1;
        int begin = 0;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                int l = i - j + 1;
                if (l > s.length()){
                    break;
                }
                if (s.charAt(i) != s.charAt(j)){
                    dp[j][i] = false;
                }else if (l <= 3){
                    dp[j][i] = true;
                }else{
                    dp[j][i] = dp[j+1][i-1];
                }
                if (dp[j][i] && maxLen < l){
                    maxLen = l;
                    begin = j;
                }
            }
        }
        return s.substring(begin,begin + maxLen);
    }




    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = 0;
        while(l < r){
            int x = r - l;
            int y = Math.min(height[l],height[r]);
            int area = x * y;
            max = Math.max(area,max);
            if (height[l] <= height[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;

    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() <= 0){
            return list;
        }
        String[] letters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backTracking(list,letters,digits,0);
        return list;
    }

    StringBuilder sb = new StringBuilder();
    private void backTracking(List<String> list,String[] letters,String digits,int num){
        if (num == digits.length()){
            list.add(sb.toString());
            return;
        }
        String str = letters[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backTracking(list,letters,digits,num+ 1);
            sb.deleteCharAt(sb.length() -1);
        }

    }


}