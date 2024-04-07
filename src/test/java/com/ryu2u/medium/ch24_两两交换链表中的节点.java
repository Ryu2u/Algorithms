package com.ryu2u.medium;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *
 * @author Administrator
 * @Description:
 * @date 2023/7/31 15:47
 */
public class ch24_两两交换链表中的节点 {
    @Test
    public void test() {
        ListNode list = new ListNode(0);
//        list.next = new ListNode(1);
//        list.next.next = new ListNode(2);
//        list.next.next.next = new ListNode(3);
        ListNode listNode = swapPairs(list);
        ListNode.printList(listNode);
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode node = cur.next;
            ListNode next = cur.next.next;
            node.next = next.next;
            next.next = node;
            cur.next = next;
            cur = cur.next.next;
        }
        return dummy.next;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }else if (head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = next.next;
        next.next = head;
        head.next = swapPairs(head.next);
        return next;
    }


}
