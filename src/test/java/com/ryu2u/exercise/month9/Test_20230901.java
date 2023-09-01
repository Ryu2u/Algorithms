package com.ryu2u.exercise.month9;

import com.ryu2u.entity.ListNode;
import com.ryu2u.entity.TreeNode;
import org.junit.Test;

import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-09-01 17:00:31
 */
public class Test_20230901 {
    @Test
    public void test() {
        // ch92
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        reverseBetween(head, 2, 4);
        // ch108
        // ch190
        int i = Integer.parseInt("111111111", 2);
        int i1 = reverseBits(i);
        System.out.println(Integer.toBinaryString(i1));
    }

    public int reverseBits(int n) {
        int num = 0;
        int c = 32;
        while (c > 0) {
            // 任何数 & 1 可以获得该数二进制的最后一位
            num = (num << 1) ^ (n & 1);
            n >>>= 1;
            c--;
        }
        return num;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sorted(nums, 0, nums.length - 1);
    }

    public TreeNode sorted(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sorted(nums, l, mid - 1);
        root.right = sorted(nums, mid + 1, r);
        return root;
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = new ListNode(0, head);
        head = node;
        for (int i = 0; i < left - 1; i++) {
            head = head.next;
        }
        ListNode cur = head.next;
        ListNode next = null;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = head.next;
            head.next = next;
        }
        return node.next;
    }

    @Test
    public void test123() {
        int j = Integer.parseInt("00001", 2);
        int i = Integer.parseInt("00001", 2);
        i = i & 1;
        j = (j << 1) ^ 1;
        System.out.println(i);
        System.out.println(j);
    }


}