import java.util.Stack;

public class S0155MinStack {
    class MinStack {
        private Stack<Integer> val = new Stack<>();
        private Stack<Integer> min = new Stack<>();
        private int m;

        public MinStack() {
            val = new Stack<>();
            min = new Stack<>();
            m = Integer.MAX_VALUE;
        }

        public void push(int x) {
            val.push(x);
            m = Math.min(m, x);
            min.push(m);
        }

        public void pop() {
            val.pop();
            min.pop();
            m = min.isEmpty() ? Integer.MAX_VALUE : min.peek();
        }

        public int top() {
            return val.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
