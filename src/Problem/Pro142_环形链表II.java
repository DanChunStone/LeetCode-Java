package Problem;

import helper.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pro142_环形链表II {

    public static void main(String[] args) {

    }

    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * 注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
     * 说明：不允许修改给定的链表。
     * 进阶：
     * 你是否可以使用 O(1) 空间解决此题？
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && slow != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            if (fast == slow) {
                ListNode top = head;
                while (top != slow) {
                    top = top.next;
                    slow = slow.next;
                }
                return top;
            }
        }
        return null;
    }

//    // hash表方法
//    public ListNode detectCycle(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        Set<ListNode> set = new HashSet<>();
//        set.add(head);
//        head = head.next;
//        while (head != null && !set.contains(head)) {
//            set.add(head);
//            head = head.next;
//        }
//        return head;
//    }
}
