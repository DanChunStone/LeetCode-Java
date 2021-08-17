package Problem;

import helper.ListNode;

import java.util.PriorityQueue;

/**
 * @author danchun
 * @date 2021/4/13 18:56
 */
public class Pro023_MergeKSortedLists {
    public static void main(String[] args) {
        ListNode listNode1 = ListNode.build(new int[]{1, 4, 5});
        ListNode listNode2 = ListNode.build(new int[]{1, 3, 4});
        ListNode listNode3 = ListNode.build(new int[]{2, 6});
        System.out.println(new Solution2().mergeKLists(new ListNode[]{listNode1, listNode2, listNode3}));
        System.out.println(new Solution2().mergeKLists(new ListNode[]{null}));
        System.out.println(new Solution2().mergeKLists(null));
    }

    /**
     * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
     * Merge all the linked-lists into one sorted linked-list and return it.
     * <p>
     * Example 1:
     * Input: lists = [[1,4,5],[1,3,4],[2,6]]
     * Output: [1,1,2,3,4,4,5,6]
     * Explanation: The linked-lists are:
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * merging them into one sorted list:
     * 1->1->2->3->4->4->5->6
     * <p>
     * Example 2:
     * Input: lists = []
     * Output: []
     * <p>
     * Example 3:
     * Input: lists = [[]]
     * Output: []
     */
    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0)
                return null;

            ListNode head = null;
            ListNode p = null;
            ListNode min;
            int minIndex = 0;
            while (true) {
                min = null;
                for (int i = 0; i < lists.length; i++) {
                    ListNode cur = lists[i];
                    if (cur != null) {
                        if (min == null || min.val > cur.val) {
                            min = cur;
                            minIndex = i;
                        }
                    }
                }
                if (min == null) {
                    break;
                }
                if (head == null) {
                    head = p = min;
                } else {
                    p.next = min;
                    p = p.next;
                }
                lists[minIndex] = lists[minIndex].next;
            }
            return head;
        }
    }
    static class Solution2 {
        class NewListNode implements Comparable<NewListNode> {
            ListNode ptr;

            public NewListNode(ListNode ptr) {
                this.ptr = ptr;
            }

            @Override
            public int compareTo(NewListNode o) {
                return ptr.val - o.ptr.val;
            }
        }

        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0)
                return null;

            PriorityQueue<NewListNode> queue = new PriorityQueue<>();
            for (ListNode list : lists) {
                if (list == null)
                    continue;
                queue.offer(new NewListNode(list));
            }
            ListNode head = new ListNode(0);
            ListNode tail = head;
            while (!queue.isEmpty()) {
                NewListNode p = queue.poll();
                tail.next = p.ptr;
                tail = tail.next;
                if (p.ptr.next != null) {
                    queue.offer(new NewListNode(p.ptr.next));
                }
            }
            return head.next;
        }
    }
}
