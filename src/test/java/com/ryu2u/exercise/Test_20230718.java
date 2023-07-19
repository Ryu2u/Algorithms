package com.ryu2u.exercise;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Administrator
 * @Description:
 * @date 2023/7/19 9:59
 */
public class Test_20230718 {

    @Test
    public void test(){
        // ch141
        // ch13
        System.out.println(romanToInt("MCMXCIV"));
        // ch88
        int[] nums1  = {1,0,0,0};
        int m = 1;
        int n = 3;
        int[] nums2  = {2,5,6};
        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m-1;
        int r = n-1;
        int i = m + n -1;
        while(l >= 0 && r >= 0){
            int ln = nums1[l];
            int rn = nums2[r];
            if (ln > rn){
                nums1[i] = ln;
                l--;
            }else{
                nums1[i] = rn;
                r--;
            }
            i--;
        }
        if (r >= 0){
            for (int j = r; j >= 0 ; j--) {
                nums1[i] = nums2[j];
                i--;
            }
        }

    }


    private static final HashMap<Character,Integer> roman = new HashMap<Character,Integer>(){
        { put('I',1);
            put('V',5);
            put('X',10);
            put('L',50);
            put('C',100);
            put('D',500);
            put('M',1000); } };

    public int romanToInt(String s) {
        int len = s.length();
        int sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (i + 1 < len){
                char c1 = s.charAt(i + 1);
                if (roman.get(c) < roman.get(c1)){
                    sum -= roman.get(c);
                    continue;
                }
            }
            sum += roman.get(c);
        }
        return sum;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow ){
                return true;
            }
        }
        return false;
    }





}
