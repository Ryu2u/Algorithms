package com.ryu2u.exercise.YEAR_2023.month9;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

/**
 * @author Ryu2u
 * @Description:
 * @date 2023-09-22 09:22:51
 */
public class Test_20230922 {
    @Test
    public void test() {
        // ch 75
        // ch 83
        ListNode listNode = ListNode.arrayToListNode(new int[]{1, 1, 1});
        ListNode listNode1 = deleteDuplicates(listNode);
        ListNode.printList(listNode1);
        // ch5
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        int l = 0;
        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int c = i - j + 1;
                if (c > len) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[j][i] = false;
                } else if (c <= 3) {
                    dp[j][i] = true;
                } else {
                    dp[j][i] = dp[j + 1][i - 1];
                }
                if (dp[j][i] && c > max) {
                    max = c;
                    l = j;
                }
            }
        }
        return s.substring(l, l + max);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode node = head;
        while (head.next != null) {
            if (head.next.val == head.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return node;
    }

    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int k = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= k) {
                r--;
            }
            int temp;
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            while (l < r && nums[l] <= k) {
                l++;
            }
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
        quickSort(nums, left, r - 1);
        quickSort(nums, l + 1, right);
    }


}