package com.ryu2u.exercise;

import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.io.File;
import java.security.SecureRandom;
import java.util.*;

/**
 * 用于每天回顾练习
 *
 * @author Administrator
 * @Description:
 * @date 2023/7/6 15:43
 */
public class Test_20230710 {

    public static final String EASY_PATH = "D:\\Project\\Demo\\JavaDEMO\\Algorithms\\src\\test\\java\\com\\ryu2u\\easy";


    /**
     * 抽题目
     */
    @Test
    public void random() {
        File file = new File(EASY_PATH);
        File[] files = file.listFiles();
        if (files == null) {
            System.out.println("文件不存在!");
            return;
        }
        Random random = new SecureRandom();
        for (int i = 0; i < 3; i++) {
            int j = random.nextInt(files.length - 1);
            System.out.println(files[j].getName());
        }

    }


    @Test
    public void ch_20230706() {
        // ch09
        System.out.println(isPalindrome(921129));
        // ch66
        int[] digits = {8, 9, 9};
        int[] ints = plusOne(digits);
        System.out.println(Arrays.toString(ints));
        // ch104
        maxDepth(new TreeNode());
        // ch144
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    public static void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }


    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left, right);
    }

    // ch09
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int len = s.length();
        int l = 0;
        int r = len - 1;
        while (l <= r) {
            char lc = s.charAt(l);
            char rc = s.charAt(r);
            if (lc != rc) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int n = len - 1;
        while (n >= 0) {
            int num = digits[n];
            if (num == 9) {
                digits[n] = 0;
                n--;
            } else {
                digits[n] += 1;
                return digits;
            }
        }
        int[] newArr = new int[len + 1];
        newArr[0] = 1;
        return newArr;
    }

    @Test
    public void test_20230708() {
        //ch145
        // ch58
        // ch69
//        System.out.println(mySqrt(2147483647));
        // ch70
        System.out.println(climbStairs(8));


    }

    public static int climbStairs(int n) {
        int pre = 0;
        int nex = 1;
        int res = 0;
        for (int i = 0; i <= n; i++) {
            pre = nex;
            nex = res;
            res = pre + nex;
        }
        return res;
    }

    public static int mySqrt(int x) {
        int l = 0, r = x, res = -1;
        while (l <= r) {
            // 取中间的数字的值而不是下标，所以要加上l
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }


    /**
     * 递归
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        post(root, list);
        return list;
    }

    public static void post(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        post(root.left, list);
        post(root.right, list);
        list.add(root.val);
    }

    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == pre) {
                list.add(root.val);
                pre = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int len = s.length();
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }


    @Test
    public void test_20230709(){
        //ch125
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        // ch5
        System.out.println(longestPalindrome("bb"));

    }

    public static boolean isPalindrome(String s) {
        s = s.trim();
        if ("".equals(s)){
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c) || Character.isLetter(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        s = sb.toString();
        System.out.println(s);
        int l = 0;
        int r = s.length()-1;
        while(l <= r){
            char cl = s.charAt(l);
            char cr = s.charAt(r);
            if (cr != cl){
                return false;
            }else{
                l++;
                r--;
            }

        }
        return true;
    }
    public static String longestPalindrome(String s) {
        if (s.length() <= 1){
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int begin = 0;
        int maxLen = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                int l = i -j +1;
                if (l > s.length()){
                    break;
                }
                if (s.charAt(i) != s.charAt(j)){
                    dp[j][i] = false;
                }else if(l <= 3){
                    dp[j][i] = true;
                }else{
                    dp[j][i] = dp[j+1][i-1];
                }

                if (dp[j][i] && l > maxLen){
                    maxLen = l;
                    begin = j;
                }
            }
        }
        return s.substring(begin,begin + maxLen);

    }

    @Test
    public void test_20230710(){
        // ch66
        int[] ints = plusOne2(new int[]{9,9,9});
        System.out.println(Arrays.toString(ints));
        // ch108
        // ch110
        // ch111
    }

    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else if(root.left == null && root.right == null){
            return 1;
        }else if(root.left == null ){
            return minDepth(root.right) + 1;
        }else if(root.right == null){
            return minDepth(root.left) + 1;
        }else{
            return Math.min(minDepth(root.left) ,minDepth(root.right)) +1;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public static int height(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (left == -1 || right == -1|| Math.abs(left -right) > 1){
            return -1;
        }else{
            return Math.max( left,right) + 1;
        }
    }


    public static int[] plusOne2(int[] digits) {
        int len = digits.length -1;
        while(len >= 0){
            int num = digits[len];
            if (num == 9){
                digits[len] = 0;
                len--;
            }else{
                digits[len]++;
                return digits;
            }
        }
        int[] arr = new int[digits.length+1];
        arr[0] = 1;
        return arr;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    public static TreeNode helper(int[] nums,int left ,int right){
        if (left > right){
            return null;
        }
        int mid = (left + right) /2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums,left,mid-1);
        node.right = helper(nums,mid+1,right);
        return node;
    }






}
