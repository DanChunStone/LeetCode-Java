package Problem;

import java.util.Deque;
import java.util.LinkedList;

public class Pro155_最小栈 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    static class MinStack {

        final Deque<Integer> mainStack;
        final Deque<Integer> subStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            mainStack = new LinkedList<>();
            subStack = new LinkedList<>();
            subStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            mainStack.push(val);
            subStack.push(Math.min(val, subStack.peek() == null ? Integer.MAX_VALUE : subStack.peek()));
        }

        public void pop() {
            mainStack.pop();
            subStack.pop();
        }

        public int top() {
            return mainStack.isEmpty() ? 0 : mainStack.peek();
        }

        public int getMin() {
            return subStack.isEmpty() ? 0 : subStack.peek();
        }
    }
}
