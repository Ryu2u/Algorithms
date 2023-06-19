package com.ryu2u.easy;

import com.ryu2u.entity.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *给定一个已排序的链表的头head，删除所有重复的元素，使每个元素只出现一次。返回已排序的链表 。
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 * @author Ryu2u
 * @Description:
 * @date 2023/6/18 14:31
 */
public class 删除排序链表中的重复元素 {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode newNode = head;
        while (head != null && head.next != null){
            int v = head.val;
            if(v == head.next.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return newNode;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        ListNode listNode = deleteDuplicates(head);
        ListNode.printList(listNode);

    }


}
