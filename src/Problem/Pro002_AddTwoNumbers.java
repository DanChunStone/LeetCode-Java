package Problem;

import helper.ListNode;

public class Pro002_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode listNode1 = ListNode.build(new int[]{5, 4, 3});
        ListNode listNode2 = ListNode.build(new int[]{5, 6, 4});

        System.out.println(listNode1.toString());
        System.out.println(listNode2.toString());
        ListNode result = new Pro002_AddTwoNumbers().addTwoNumbers(listNode1, listNode2);
        System.out.println(result.toString());
    }

    /**
     * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        int carry = 0;

        ListNode head = null, current = null;
        while (p != null || q != null) {
            if (head == null) {
                current = new ListNode();
                head = current;
            } else {
                current.next = new ListNode();
                current = current.next;
            }

            int sum = carry;
            if (p != null) {
                sum += p.val;
                p = p.next;
            }
            if (q != null) {
                sum += q.val;
                q = q.next;
            }
            carry = sum / 10;
            current.val = sum % 10;
        }

        if (carry > 0) {
            current.next = new ListNode();
            current = current.next;
            current.val = carry;
        }

        return head;
    }
}