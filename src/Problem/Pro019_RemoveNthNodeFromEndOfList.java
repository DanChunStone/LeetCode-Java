package Problem;

import helper.ListNode;

/**
 * @author danchun
 * @date 2021/4/7 11:32
 */
public class Pro019_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode node1 = ListNode.build(new int[]{1, 2, 3, 4, 5});
        ListNode node2 = ListNode.build(new int[]{1});
        ListNode node3 = ListNode.build(new int[]{1, 2});

        System.out.println(new Solution().removeNthFromEnd(node1, 2));
        System.out.println(new Solution().removeNthFromEnd(node2, 1));
        System.out.println(new Solution().removeNthFromEnd(node3, 1));
    }

    /**
     * Given the head of a linked list, remove the nth node from the end of the list and return its head.
     * Follow up: Could you do this in one pass?
     * <p>
     * Example 1:
     * Input: head = [1,2,3,4,5], n = 2
     * Output: [1,2,3,5]
     * <p>
     * Example 2:
     * Input: head = [1], n = 1
     * Output: []
     * <p>
     * Example 3:
     * Input: head = [1,2], n = 1
     * Output: [1]
     */
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null || (head.next == null && n == 1) || n <= 0) {
                return null;
            }

            ListNode p = head;
            while (p != null && n != 0) {
                p = p.next;
                n--;
            }
            if (n != 0) { // 倒数超过长度
                return head;
            }
            ListNode q = head, qPre = null;
            while (p != null) {
                qPre = q;
                q = q.next;
                p = p.next;
            }
            if (qPre == null) {
                qPre = head.next;
                head.next = null;
                return qPre;
            }
            qPre.next = q.next;
            return head;
        }
    }
}
