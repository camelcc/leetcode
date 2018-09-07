public class S0622DesignCircularQueue {
    class MyCircularQueue {
        private int[] queue;
        private int N;
        private int head;
        private int tail;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            this.N = k+1;
            queue = new int[k+1];
            head = 0;
            tail = 0;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }

            queue[tail] = value;
            tail = (tail + 1) % N;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }

            head = (head + 1) % N;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return queue[head];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return queue[(tail + N - 1) % N];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return head == tail;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return (tail + 1) % N == head;
        }
    }
}
