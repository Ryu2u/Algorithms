package com.ryu2u.easy;

import com.ryu2u.entity.ListNode;

/**
 *将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * @author Administrator
 * @Description:
 * @date 2023/6/13 13:26
 */
public class 合并两个有序链表 {
    /**
     * 迭代法
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        ListNode newNode = new ListNode();
        ListNode head = newNode;
        while (list1 != null && list2 != null){
            int v1 = list1.val;
            int v2 = list2.val;
            if(v1 <= v2){
                ListNode node = new ListNode(v1);
                newNode.next = node;
                newNode = newNode.next;
                list1 = list1.next;
            }else{
                ListNode node = new ListNode(v2);
                newNode.next = node;
                newNode = newNode.next;
                list2 = list2.next;
            }
        }
        if(list1 != null){
            newNode.next = list1;
        }else{
            newNode.next = list2;
        }
        return head.next;
    }

    /**
     * 递归
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = mergeTwoLists2(list1.next,list2);
            return list1;
        }else{
            list2.next = mergeTwoLists2(list1,list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode();
        list1.val = 1;
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode();
        list2.val = 1;
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
//        ListNode head = mergeTwoLists(list1, list2);
        ListNode head = mergeTwoLists2(list1, list2);
        ListNode.printList(head);
    }
}
