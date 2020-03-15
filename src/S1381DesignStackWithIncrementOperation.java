import util.Utils;

public class S1381DesignStackWithIncrementOperation {
    public static class CustomStack {
        private int[] data;
        private int top;

        public CustomStack(int maxSize) {
            data = new int[maxSize];
            top = 0;
        }

        public void push(int x) {
            if (top >= data.length) {
                return;
            }
            data[top++] = x;
        }

        public int pop() {
            if (top == 0) {
                return -1;
            }
            int r = data[top-1];
            top--;
            return r;
        }

        public void increment(int k, int val) {
            for (int i = 0; i < Math.min(k, top); i++) {
                data[i] += val;
            }
        }
    }
}
