package Problem;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 剑指Offer09_用两个栈实现队列 {

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        int x1 = cQueue.deleteHead();
        int x2 = cQueue.deleteHead();
        System.out.println("" + x1 + x2);

        CQueue cQueue2 = new CQueue();
        cQueue2.deleteHead();
        cQueue2.appendTail(5);
        cQueue2.appendTail(2);
        int a1 = cQueue2.deleteHead();
        int a2 = cQueue2.deleteHead();
        System.out.println("" + a1 + a2);
    }

    static class CQueue {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (!stack2.isEmpty()) {
                return stack2.pop();
            } else {
                return -1;
            }
        }
    }

}
