package Problem;

import helper.ListNode;

public class Pro160_相交链表 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        System.out.println(new Pro160_相交链表().getIntersectionNode(node1, node2));
    }

    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
     * 图示两个链表在节点 c1 开始相交：
     * <p>
     * 题目数据 保证 整个链式结构中不存在环。
     * 注意，函数返回结果后，链表必须 保持其原始结构 。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA, q = headB;
        boolean hasPExchange = false;
        boolean hasQExchange = false;

        while (p != q) {
            p = p.next;
            q = q.next;

            if ((hasPExchange && p == null) || (hasQExchange && q == null)) {
                return null;
            }
            if (p == null) {
                hasPExchange = true;
                p = headB;
            }
            if (q == null) {
                hasQExchange = true;
                q = headA;
            }
        }
        return p;
    }
}
