package com.ryu2u.exercise;

import com.ryu2u.entity.TreeNode;
import org.junit.Test;

/**
 *
 * @author Administrator
 * @Description:
 * @date 2023/7/14 9:08
 */
public class Test_20230714 {

    @Test
    public void test(){
        // ch101
        // ch724
        // ch168
        System.out.println(convertToTitle(701));
        char c = 'A' -1;
        System.out.println(c);
        System.out.println((int)c);
        System.out.println((int)'A');

    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int n = columnNumber;
        while(n!=0){
            n--;
            char  c = (char) ('A' + n % 26);
            sb.append(c);
            n /= 26;
        }
        return sb.reverse().toString();
    }

    public static int pivotIndex(int[] nums) {
        int total = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            total += nums[i];
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < len; i++) {
            left += nums[i];
            right = total - left + nums[i];
            if (left == right){
                return i;
            }
        }
        return -1;
    }

    public static boolean isSymmetric(TreeNode root) {
        return isSame(root.left,root.right);
    }

    private static boolean isSame(TreeNode node1,TreeNode node2){
        if (node1 == null && node2 == null){
            return true;
        }else if (node1 == null){
            return false;
        }else if(node2 == null){
            return false;
        }else if (node1.val != node2.val){
            return false;
        }else{
            return isSame(node1.left,node2.right) && isSame(node1.right,node2.left);
        }
    }




}
