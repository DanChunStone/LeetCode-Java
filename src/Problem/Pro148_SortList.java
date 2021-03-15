package Problem;

import helper.ListNode;

/**
 * @author shilijun
 * @date 2020/11/21 11:34
 */
public class Pro148_SortList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(0);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode head = new Pro148_SortList().sortList(node1);
        ListNode p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    /**
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode end) {
        if (head == null) {
            return null;
        }
        if (head.next == end) {
            head.next = null;
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast != end) {
            slow = slow.next;
            fast = fast.next;
            if (fast != end) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode left = sortList(head, mid);
        ListNode right = sortList(mid, end);
        return merge(left, right);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode head;
        ListNode p;
        ListNode q;
        if (list1.val >= list2.val) {
            head = list2;
            p = list1;
            q = list2.next;
        } else {
            head = list1;
            p = list1.next;
            q = list2;
        }
        ListNode cur = head;

        while (p != null || q != null) {
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
                cur = cur.next;
                p = p.next;
            } else {
                cur.next = q;
                cur = cur.next;
                q = q.next;
            }
        }

        return head;
    }
}