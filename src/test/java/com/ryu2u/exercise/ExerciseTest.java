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
public class ExerciseTest {

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


}
