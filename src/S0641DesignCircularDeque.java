public class S0641DesignCircularDeque {
    class MyCircularDeque {
        private int N;
        private int[] queue;
        private int head;
        private int tail;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            N = k + 1;
            queue = new int[k + 1];
            head = 0;
            tail = 0;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }

            head = (head + N - 1) % N;
            queue[head] = value;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }

            queue[tail] = value;
            tail = (tail + 1) % N;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }

            head = (head + 1) % N;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }

            tail = (tail + N - 1 ) % N;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (isEmpty()) {
                return  -1;
            }

            return queue[head];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }

            return queue[(tail - 1 + N) % N];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return head == tail;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return (tail + 1) % N == head;
        }
    }
}
