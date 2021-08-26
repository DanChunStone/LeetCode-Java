package Problem;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 剑指Offer30_包含min函数的栈 {

    public static void main(String[] args) {

    }

    class MinStack {

        Deque<Integer> mainStack = new LinkedList<>();
        Deque<Integer> minStack = new LinkedList<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            mainStack.push(x);
            minStack.push(Math.min(x, minStack.peek()));
        }

        public void pop() {
            mainStack.pop();
            minStack.pop();
        }

        public int top() {
            return mainStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */

}
