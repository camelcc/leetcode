import java.util.Stack;

public class S0155MinStack {
    class MinStack {
        private Stack<Integer> stack = new Stack<>();
        private int min;

        public MinStack() {
            stack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            stack.push(min);
            stack.push(x);
            min = x < min ? x : min;
        }

        public void pop() {
            stack.pop();
            min = stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
