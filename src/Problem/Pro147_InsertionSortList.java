package Problem;

import helper.ListNode;

/**
 * @author shilijun
 * @date 2020/11/20 14:07
 */
public class Pro147_InsertionSortList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(0);

//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        ListNode head = new Pro147_InsertionSortList().insertionSortList(node1);
        ListNode p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode p = null;
            ListNode q = head;

            while (q != cur) {
                if (q.val > cur.val) {
                    if (p == null) {
                        head = cur;
                    } else {
                        p.next = cur;
                    }
                    pre.next = cur.next;
                    cur.next = q;
                    cur = pre.next;
                    break;
                }
                p = q;
                q = q.next;
            }

            if (q == cur) {
                pre = cur;
                cur = cur.next;
            }
        }

        return head;
    }
}
