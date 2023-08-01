package com.ryu2u.exercise.month7;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-07-26 17:16:45
 */
public class Test_20230726 {
    @Test
    public void test() {
        //ch12
        System.out.println(intToRoman(20));
        // ch16
        int[] nums = {-1000, -5, -5, -5, -5, -5, -5, -1, -1, -1};
        int target = -14;
        System.out.println(threeSumClosest(nums, target));
        // ch2
        //ch15

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                break;
            }
            if (i >0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i +1;
            int r = nums.length-1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0){
                    list.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l <r && nums[l] == nums[l + 1]){
                        l++;
                    }
                    while(l < r && nums[r] == nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                }else if (sum > 0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return list;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode newNode = node;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2;
            if (carry != 0) {
                sum += carry;
                carry = 0;
            }
            if (sum >= 10) {
                carry = sum / 10;
                sum %= 10;
            }
            node.next = new ListNode(sum);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            node = node.next;
        }
        if (carry != 0) {
            node.next = new ListNode(1);
        }
        return newNode.next;

    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int temp = nums[i] + nums[l] + nums[r];
                if (temp == target) {
                    return temp;
                }
                if (Math.abs(target - sum) >= Math.abs(target - temp)) {
                    System.out.println(i + " " + l + " " + r);
                    sum = temp;
                }
                if (temp < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return sum;

    }


    int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    String[] letters = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            for (int i = values.length - 1; i >= 0; i--) {
                if (num >= values[i]) {
                    sb.append(letters[i]);
                    num -= values[i];
                    break;
                }
            }
        }
        return sb.toString();

    }


}