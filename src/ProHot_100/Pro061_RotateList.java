package ProHot_100;

import helper.ListNode;

/**
 * @author shilijun
 * @date 2021/3/27 16:02
 */
public class Pro061_RotateList {
    public static void main(String[] args) {
        ListNode head = new Solution().rotateRight(ListNode.build(new int[]{1, 2, 3, 4, 5}), 2);
        System.out.println(head.toString());
    }

    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null || k == 0)
                return head;

            int length = 0;
            ListNode p = head;
            while (p.next != null) {
                length++;
                p = p.next;
            }
            length++;
            p.next = head;

            k = length - k % length;

            while (k > 0) {
                p = head;
                head = head.next;
                k--;
            }
            p.next = null;

            return head;
        }
    }
}
