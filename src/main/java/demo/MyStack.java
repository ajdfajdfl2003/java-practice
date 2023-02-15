package demo;

import java.util.Stack;

public class MyStack {
    public static void main(String[] args) {
        final MaxStack maxStack = new MaxStack();
        System.out.println(maxStack.getMax());
        maxStack.push(1);
        System.out.println(maxStack.getMax());
        maxStack.push(1);
        System.out.println(maxStack.getMax());
        maxStack.pop();
        System.out.println(maxStack.top());
        System.out.println(maxStack.top());
    }

    public static class MaxStack {
        private final Stack<Integer> stack;
        private int max = Integer.MIN_VALUE;

        // 初始化
        public MaxStack() {
            this.stack = new Stack<>();
        }

        // 判斷如果x >= max，先將目前的max放入stack後面，再放入x
        public void push(int x) {
            if (x >= max) {
                this.stack.push(max);
                this.max = x;
            }
            this.stack.push(x);
        }

        // 如果取出的值剛好就是max，因之前把第二大的數放在max前面，所以也要被pop
        public void pop() {
            if (stack.peek() == this.max) {
                this.stack.pop();
                max = this.stack.pop();
            } else {
                this.stack.pop();
            }
        }

        // 取top element
        public int top() {
            return this.stack.peek();
        }

        // 取max
        public int getMax() {
            return max;
        }
    }
}
