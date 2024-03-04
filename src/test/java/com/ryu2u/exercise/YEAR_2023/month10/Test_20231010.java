package com.ryu2u.exercise.YEAR_2023.month10;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-10-10 13:21:00
 */
public class Test_20231010 {
    @Test
    public void test() {
        // ch61
        ListNode node = ListNode.arrayToListNode(new int[]{1});

        ListNode listNode = rotateRight(node, 3);
        ListNode.printList(listNode);
        // ch219
        // ch217

    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int k = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == k) {
                return true;
            } else {
                k = nums[i];
            }
        }
        return false;

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int l = map.get(nums[i]);
                if (i - l <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        } else if (k <= 0) {
            return head;
        }
        int len = 0;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            len++;
        }
        k = k % ++len;
        temp.next = head;
        for (int i = 0; i < len - k - 1; i++) {
            head = head.next;
        }
        System.out.println(head.val);
        temp = head.next;
        head.next = null;
        return temp;
    }


}