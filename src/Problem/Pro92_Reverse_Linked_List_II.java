package Problem;

import helper.ListNode;

public class Pro92_Reverse_Linked_List_II {
    public static void main(String[] args) {
//        System.out.println(new Pro92_Reverse_Linked_List_II().reverseBetween(ListNode.build(new int[]{1,2,3,4,5}), 1, 1).toString());
        System.out.println(new Pro92_Reverse_Linked_List_II().reverseBetween(ListNode.build(new int[]{5}), 1, 1).toString());
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head == null)
            return head;

        int index = 1;
        ListNode newHead = null;
        ListNode p = head;
        ListNode q = head.next;

        while (index < left) {
            newHead = p;
            p = p.next;
            q = p.next;
            index++;
        }

        ListNode subTail = p;
        while (left < right) {
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;

            left++;
        }
        ListNode subHead = p;

        subTail.next = q;
        if (newHead != null) {
            newHead.next = subHead;
        } else {
            head = subHead;
        }
        
        return head;
    }
}
