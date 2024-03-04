package com.ryu2u.exercise.YEAR_2024.month3;

import org.junit.Test;
import com.ryu2u.entity.TreeNode;
import com.ryu2u.entity.ListNode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2024-03-04 13:03:24
 */
public class Test_20240304 {

    @Test
    public void test1() {
        int[] arr = {1, 1, 1, 2, 2, 2};
        int len = removeDuplicates(arr);
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // ch80
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return len;
        }
        int l = 2;
        int r = 2;
        while (r < len) {
            if (nums[l - 2] != nums[r]) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }

    @Test
    public void test2() {
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> list = summaryRanges(nums);
        System.out.println(list);
    }

    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < len) {
            int l = i;
            i++;
            while (i < len && nums[i] - nums[i - 1] == 1) {
                i++;
            }
            int h = i - 1;
            if (l == h) {
                list.add(String.valueOf(nums[l]));
            } else {
                list.add(nums[l] + "->" + nums[h]);
            }
        }
        return list;

    }


    @Test
    public void test3() {

    }

    // ch11
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            int a = height[l];
            int b = height[r];
            max = Math.max(max, Math.min(a, b) * (r - l));
            if (a < b) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }


    @Test
    public void test4() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    // ch49
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>(16);
        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String raw = Arrays.toString(cs);
            if (map.containsKey(raw)) {
                map.get(raw).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(raw, list);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for (String s : map.keySet()) {
            List<String> l = map.get(s);
            list.add(l);
        }
        return list;
    }

    @Test
    public void test5() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] ints = searchRange(nums, target);
        System.out.println(Arrays.toString(ints));

    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length <= 0) {
            return new int[]{-1, -1};
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                int start = mid;
                int end = mid;
                while (start > 0 && nums[start] == nums[start - 1]) {
                    start--;
                }
                while (end < nums.length - 1 && nums[end] == nums[end + 1]) {
                    end++;
                }
                return new int[]{start, end};
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }

    @Test
    public void test6() {

    }

    public boolean isValidSudoku(char[][] board) {
        int[][] cols = new int[9][9];
        int[][] rows = new int[9][9];
        int[][][] boxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int n = c - '1';
                cols[j][n]++;
                rows[i][n]++;
                boxes[i / 3][j / 3][n]++;
                if (cols[j][n] > 1 || rows[i][n] > 1 || boxes[i / 3][j / 3][n] > 1) {
                    return false;
                }
            }
        }
        return true;

    }


    @Test
    public void test7() {
        String n1 = "9124123";
        String n2 = "9123123";
        System.out.println(multiply(n1, n2));
        BigDecimal d1 = new BigDecimal(n1);
        BigDecimal d2 = new BigDecimal(n2);
        System.out.println(d1.multiply(d2));
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String res = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            String str = stringMultiply(num1, num2.charAt(i) - '0');
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                str += "0";
            }
            res = strAdd(res, str);
        }
        return res;
    }

    public String stringMultiply(String str, int num) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            int n = str.charAt(i) - '0';
            int sum = n * num + carry;
            carry = 0;
            if (sum > 9) {
                carry = sum / 10;
                sum %= 10;
            }
            sb.append(sum);
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public String strAdd(String str1, String str2) {
        int l = str1.length() - 1;
        int r = str2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int step = 0;
        while (l >= 0 || r >= 0) {
            int nl = l >= 0 ? str1.charAt(l) - '0' : 0;
            int rl = r >= 0 ? str2.charAt(r) - '0' : 0;
            int sum = nl + rl + step;
            step = 0;
            if (sum > 9) {
                step = sum / 10;
                sum %= 10;
            }
            sb.append(sum);
            l--;
            r--;
        }
        if (step != 0) {
            sb.append(step);
        }
        return sb.reverse().toString();
    }

    @Test
    public void test8() {

    }


    // ch2
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode node = new ListNode(0);
        ListNode head = node;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            carry = 0;
            if (sum > 9) {
                carry = sum / 10;
                sum %= 10;
            }
            node.next = new ListNode(sum);
            node = node.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry != 0) {
            node.next = new ListNode(carry);
        }

        return head.next;
    }

    @Test
    public void test9() {

    }

    // ch19
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0, head);
        ListNode node2 = node;
        ListNode raw = node;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        while (node.next != null) {
            node = node.next;
            node2 = node2.next;
        }
        node2.next = node2.next.next;
        return raw.next;
    }

    @Test
    public void test10() {

    }


    // ch111
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

    @Test
    public void test11() {

    }

    // ch205
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int n = 0;
        int[] arr1 = new int[s.length()];
        int[] arr2 = new int[t.length()];
        for (int i = 0; i < s.length(); i++) {
            if (!map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), n++);
            }
            arr1[i] = map1.get(s.charAt(i));
        }
        n = 0;
        for (int i = 0; i < t.length(); i++) {
            if (!map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), n++);
            }
            arr2[i] = map2.get(t.charAt(i));
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }


}