package com.ryu2u.easy;

import com.ryu2u.entity.ListNode;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * @author Administrator
 * @Description:
 * @date 2023-06-30 13:28:51
 */
public class ch141_环形链表	{
    /**
     * 快慢指针
     * 定义两个指针，同时从链表的头结点出发，
     * 一个指针一次走两步，一个一次走一步，
     * 如果两个指针相遇了，说明是环
     * 如果需要获取换的长度，则判断两个指针两次相遇的移动次数
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head==null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && slow.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

}