import java.util.ArrayList;
import java.util.List;

public class S0225ImplementStackusingQueues {
    class MyStack {
        private List<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack() {
            queue = new ArrayList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            List<Integer> tmp = new ArrayList<>();
            while (!queue.isEmpty()) {
                tmp.add(queue.remove(0));
            }
            queue.add(x);
            while (!tmp.isEmpty()) {
                queue.add(tmp.remove(0));
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.remove(0);
        }

        /** Get the top element. */
        public int top() {
            return queue.get(0);
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
