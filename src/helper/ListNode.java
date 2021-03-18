package helper;

/**
 * @author shilijun
 * @date 2020/11/21 11:35
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ListNode{");

        stringBuilder.append(val);
        ListNode theNext = next;
        while (theNext != null) {
            stringBuilder.append(" -> ").append(theNext.val);
            theNext = theNext.next;
        }

        stringBuilder.append("}");
        return stringBuilder.toString();
    }
    
    public static ListNode build(int[] values) {
        if (values.length <= 0)
            return null;
        ListNode head = new ListNode(values[0]);
        ListNode temp = head;
        int index = 1;
        while (index < values.length) {
            temp.next = new ListNode(values[index]);
            temp = temp.next;
            index++;
        }
        return head;
    }
}
