package com.ryu2u.exercise.month7;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023/7/15 10:45
 */
public class Test_20230715 {
    @Test
    public void test() {
        // ch26
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        removeDuplicates(nums);
        // ch21
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode listNode = mergeTwoLists(list1, list2);
        ListNode.printList(listNode);
        // ch69
        System.out.println(mySqrt(2147395599));
        // ch171
        System.out.println(titleToNumber("FXSHRXW"));
    }

    public int titleToNumber(String columnTitle) {
        int len = columnTitle.length()-1;
        int sum = 0;
        for (int i = len; i >= 0; i--) {
            char c = columnTitle.charAt(i);
            sum += (int)Math.pow(26,len-i) * (c - 'A' +1);
        }
        return sum;
    }


    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int k = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if ((long)mid * mid <= x){
                k = mid;
                l = mid +1;
            }else{
                r = mid -1;
            }
        }
        return k;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode node = new ListNode();
        ListNode head = node;
        while (list1 != null && list2 != null) {
            ListNode temp = new ListNode();
            if (list1.val < list2.val) {
                temp.val = list1.val;
                list1 = list1.next;
            } else {
                temp.val = list2.val;
                list2 = list2.next;
            }
            node.next = temp;
            node = node.next;
        }
        if (list1 != null) {
            node.next = list1;
        } else {
            node.next = list2;
        }
        return head.next;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }

    public int removeDuplicates(int[] nums) {
        int p = 0;
        int b = 0;
        while (b < nums.length) {
            int n1 = nums[p];
            int n2 = nums[b];
            if (n1 != n2) {
                nums[++p] = n2;
            }
            b++;
        }
        System.out.println(Arrays.toString(nums));
        return p + 1;
    }


}
