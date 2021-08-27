package Problem;

import helper.ListNode;

public class Pro206_反转链表 {

    public static void main(String[] args) {
        System.out.println(new Pro206_反转链表().reverseList(ListNode.build(new int[]{1, 2, 3, 4, 5})));
    }


    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head, q = head.next;
        p.next = null;
        while (q != null) {
            ListNode temp = p;
            p = q;
            q = q.next;
            p.next = temp;
        }
        return p;
    }
}
