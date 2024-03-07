package com.ryu2u.medium;

import com.ryu2u.entity.ListNode;
import org.junit.Test;

import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2024/3/7 18:08
 */
public class ch707_设计链表 {
    @Test
    public void test() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        myLinkedList.get(1);              // 返回 2
        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
        myLinkedList.get(1);
    }

    class MyLinkedList {

        class ListNode {
            int val;
            ListNode next;

            public ListNode(int val) {
                this.val = val;
            }
        }

        int size;
        ListNode head;

        public MyLinkedList() {
            this.head = new ListNode(0);
            size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }

            ListNode dummy = head;
            for (int i = 0; i <= index; i++) {
                dummy = dummy.next;
            }
            return dummy.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }

            if (index < 0) {
                index = 0;
            }

            ListNode dummy = head;
            for (int i = 0; i < index; i++) {
                dummy = dummy.next;
            }
            ListNode newNode = new ListNode(val);
            newNode.next = dummy.next;
            ;
            dummy.next = newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            if (index == 0) {
                head = head.next;
            } else {
                ListNode dummy = head;
                for (int i = 0; i < index; i++) {
                    dummy = dummy.next;
                }
                dummy.next = dummy.next.next;
            }
            size--;
        }

    }

}
