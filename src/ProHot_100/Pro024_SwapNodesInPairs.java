package ProHot_100;

import helper.ListNode;

import java.util.List;

public class Pro024_SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode listNode1 = ListNode.build(new int[]{1, 2, 3, 4});
        ListNode listNode2 = null;
        ListNode listNode3 = ListNode.build(new int[]{1});
        System.out.println(new Solution().swapPairs(listNode1).toString());
//        System.out.println(new Solution().swapPairs(listNode2).toString());
        System.out.println(new Solution().swapPairs(listNode3).toString());
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null)
                return head;

            ListNode newHead = new ListNode(0);
            newHead.next = head;
            ListNode last = newHead;
            ListNode p = head, q = head.next;
            while (p != null && q != null) {
                // last -> p -> q -> next
                ListNode temp = q.next;
                q.next = p;
                last.next = q;
                p.next = temp;
                last = p;

                p = p.next;
                if (p != null)
                    q = p.next;
            }
            return newHead.next;
        }
    }
}
