package com.ryu2u.easy;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

/**
 *给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * 提示：
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 * @author Ryu2u
 * @Description:
 * @date 2023/7/15 13:18
 */
public class ch203_移除链表元素 {
    @Test
    public void test(){
        ListNode head = new ListNode(7);
        head.next = new ListNode(7);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next = new ListNode(7);
        ListNode listNode = removeElements(head, 7);
        ListNode.printList(listNode);
    }

    /**
     * 虚拟头结点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode newNode = new ListNode();
        ListNode node = newNode;
        while(head != null){
            if (head.val != val){
                newNode.next = new ListNode(head.val);
                newNode = newNode.next;
            }
            head = head.next;
        }
        return node.next;
    }

    /**
     * 递归
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        head.next = removeElements(head.next,val);
        if (head.val == val){
            return head.next;
        }else{
            return head;
        }
    }

}

