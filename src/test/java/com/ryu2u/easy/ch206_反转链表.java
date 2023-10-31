package com.ryu2u.easy;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * <p>
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * <p>
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * <p>
 * <p>
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 *
 * @author Administrator
 * @Description:
 * @date 2023/7/17 15:43
 */
public class ch206_反转链表 {

    @Test
    public void test() {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        ListNode listNode = reverseList(list);
        ListNode.printList(listNode);
    }


    /**
     * 迭代法
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode nex = null;
        // 1 -> 2 -> 3
        // 流程为 1:   1 -> null
        //       2:   2 -> 1 -> null
        //       3:   3 -> 2 -> null
        while (head != null) {
            nex = head.next;
            head.next = pre;
            pre = head;
            head = nex;
        }
        return pre;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


}
