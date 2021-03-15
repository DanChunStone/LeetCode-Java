package ProHot_100;

public class Pro002_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(8);
        
        ListNode result = new Pro002_AddTwoNumbers().addTwoNumbers(listNode1, listNode2);
        while (result != null) {
            System.out.print(result.val + "-> ");
            result = result.next;
        }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        int carry = 0;
        
        ListNode head = null, current = null;
        while (p != null && q != null) {
            int sum = p.val + q.val + carry;
            
            if (head == null) {
                current = new ListNode();
                head = current;
            } else {
                current.next = new ListNode();
                current = current.next;
            }
            
            carry = sum / 10;
            current.val = sum % 10;
            
            p = p.next;
            q = q.next;
        }
        
        while (p != null || q != null) {
            if (head == null) {
                current = new ListNode();
                head = current;
            } else {
                current.next = new ListNode();
                current = current.next;
            }
            
            int sum;
            if (p != null) {
                sum = p.val + carry;
                p = p.next;
            } else {
                sum = q.val + carry;
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

    private static class ListNode {
        public int val;
        public ListNode next;

        ListNode() { }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}