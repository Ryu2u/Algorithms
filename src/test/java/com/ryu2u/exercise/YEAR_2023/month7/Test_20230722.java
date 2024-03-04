package com.ryu2u.exercise.YEAR_2023.month7;
import com.ryu2u.entity.ListNode;
import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023-07-22 08:50:26
 */
public class Test_20230722	{
    @Test
    public void test(){
        //ch300
        // ch66
        // ch203
        // ch111
        // ch21
        // ch191
        int n = 3;
        System.out.println(hammingWeight(n));
        //ch226
        // ch228
        int[] nums = {-2147483648,-2147483647,2147483647};
        System.out.println(summaryRanges(nums));

        String str = "1234567";
        int i = str.lastIndexOf("4");
        System.out.println(i);
        System.out.println(str.substring(0, i));

    }

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length <= 0){
            return list;
        }
        list.add(String.valueOf(nums[0]));
        if (nums.length == 1){
            return list;
        }
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int pre = nums[i-1];
            if (cur - pre == 1){
                String str = list.get(list.size()-1);
                int n = str.lastIndexOf("->");
                if (n != -1){
                    str = str.substring(0,n);
                }
                str += "->" + cur;
                list.set(list.size()-1,str);
            }else{
                list.add(String.valueOf(cur));
            }
        }
        return list;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }

    public int hammingWeight(int n) {
        if (n == 0){
            return 0;
        }
        int count = 0;
        while(n != 0){
            if ((n & 0x01) == 1){
                count++;
            }
            n >>>= 1;
        }
        return count;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null){
            return null;
        }else if (list1 == null){
            return list2;
        }else if (list2 == null){
            return list1;
        }else if (list1.val <= list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
        }


    }

    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else if (root.left == null && root.right == null){
            return 1;
        }else if (root.left == null){
            return minDepth(root.right) + 1;
        }else if (root.right == null){
            return minDepth(root.left) + 1;
        }else{
            return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
        }

    }


    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        head.next = removeElements(head.next,val);
        if (head.val == val){
            return head.next;
        }else{
            return head;
        }
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length-1;
        while(len >= 0){
            int num = digits[len];
            if (num == 9){
                digits[len] = 0;
                len--;
            }else{
                digits[len] += 1;
                return digits;
            }
        }
        int[] arr = new int[digits.length + 1];
        arr[0] = 1;
        return arr;

    }


    public int lengthOfLIS(int[] nums) {
        int[] f = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    f[i] = Math.max(f[i],f[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans,f[i]);
        }
        return ans;


    }



}