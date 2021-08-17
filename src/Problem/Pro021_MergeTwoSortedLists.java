package Problem;

import helper.ListNode;

/**
 * @author shilijun
 * @date 2020/11/21 13:21
 */
public class Pro021_MergeTwoSortedLists {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode head, cur, p, q;
        if (l1.val < l2.val) {
            head = l1;
            p = l1.next;
            q = l2;
        } else {
            head = l2;
            p = l1;
            q = l2.next;
        }
        cur = head;

        while (true) {
            if (p == null) {
                cur.next = q;
                break;
            }
            if (q == null) {
                cur.next = p;
                break;
            }

            if (p.val < q.val) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }

        return head;
    }
}
