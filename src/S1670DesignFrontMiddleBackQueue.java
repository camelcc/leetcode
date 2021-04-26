import java.util.LinkedList;

public class S1670DesignFrontMiddleBackQueue {
    public static class FrontMiddleBackQueue {
        LinkedList<Integer> front;
        LinkedList<Integer> back;

        public FrontMiddleBackQueue() {
            front = new LinkedList<>();
            back = new LinkedList<>();
        }

        public void pushFront(int val) {
            front.addFirst(val);
            if (front.size() > back.size()) {
                back.addFirst(front.pollLast());
            }
        }

        public void pushMiddle(int val) {
            front.addLast(val);
            if (front.size() > back.size()) {
                back.addFirst(front.pollLast());
            }
        }

        public void pushBack(int val) {
            back.addLast(val);
            if (back.size() > front.size()+1) {
                front.addLast(back.pollFirst());
            }
        }

        public int popFront() {
            if (!front.isEmpty()) {
                int res = front.pollFirst();
                if (front.size() < back.size()-1) {
                    front.addLast(back.pollFirst());
                }
                return res;
            } else {
                if (back.isEmpty()) {
                    return -1;
                } else {
                    return back.pollFirst();
                }
            }
        }

        public int popMiddle() {
            if (front.size() == back.size()) {
                if (front.isEmpty()) {
                    return -1;
                }
                return front.pollLast();
            } else {
                return back.pollFirst();
            }
        }

        public int popBack() {
            if (back.isEmpty()) {
                if (front.isEmpty()) {
                    return -1;
                } else {
                    return front.pollLast();
                }
            } else {
                int res = back.pollLast();
                if (back.size() < front.size()) {
                    back.addFirst(front.pollLast());
                }
                return res;
            }
        }
    }
}
