package com.ryu2u.medium;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * <p>
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 *
 * @author Administrator
 * @Description:
 * @date 2023/9/11 15:46
 */
public class ch82_删除排序链表中的重复元素II {
    @Test
    public void test() {
        int[] arr = {2, 2, 2, 2, 2, 2, 2};
        ListNode listNode = ListNode.arrayToListNode(arr);
        ListNode listNode1 = deleteDuplicates(listNode);
        ListNode.printList(listNode1);

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = new ListNode(0);
        ListNode newNode = node;
        while (head != null) {
            if (head.next == null) {
                node.next = new ListNode(head.val);
                break;
            }
            if (head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                head = head.next;
            } else {
                node.next = new ListNode(head.val);
                head = head.next;
                node = node.next;
            }
        }
        return newNode.next;
    }

}
