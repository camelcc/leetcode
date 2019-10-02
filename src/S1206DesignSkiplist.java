import java.util.LinkedList;
import java.util.Random;

public class S1206DesignSkiplist {
    class Skiplist {
        private class Node {
            Node prev, next, up, down;
            int val;

            public Node(int v) {
                this.val = v;
            }
        }

        private Random rand;
        private LinkedList<Node> levels;

        private void insert(Node list, Node n) {
            assert list != null;
            if (list.next != null) {
                list.next.prev = n;
            }
            n.next = list.next;
            n.prev = list;
            list.next = n;
        }

        public Skiplist() {
            rand = new Random();
            levels = new LinkedList<>();
            levels.offer(new Node(-1));
        }

        public boolean search(int target) {
            return bottomNoLarger(target).val == target;
        }

        public void add(int num) {
            Node n = bottomNoLarger(num);
            Node added = new Node(num);
            insert(n, added);
            swimUp(added);
        }

        private void swimUp(Node node) {
            Node prev = node.prev, current = node;
            while (flipCoin()) {
                while (prev.prev != null && prev.up == null) {
                    prev = prev.prev;
                }
                if (prev.up == null) { // head of current level
                    Node head = new Node(-1);
                    prev.up = head;
                    head.down = prev;
                    levels.offer(head);
                }
                prev = prev.up;
                Node n = new Node(node.val);
                current.up = n;
                n.down = current;
                n.next = prev.next;
                if (prev.next != null) {
                    prev.next.prev = n;
                }

                current = current.up;
                prev.next = current;
                current.prev = prev;
            }
        }

        public boolean erase(int num) {
            Node n = bottomNoLarger(num);
            if (n.val != num) {
                return false;
            }

            Node del = n;
            while (del != null) {
                if (del.next != null) {
                    del.next.prev = del.prev;
                }
                del.prev.next = del.next;
                del = del.up;
            }
            return true;
        }

        private Node bottomNoLarger(int target) {
            Node top = levels.getLast();
            while (top != null) {
                if (top.next == null || top.next.val > target) {
                    if (top.down == null) {
                        break;
                    }

                    top = top.down;
                } else {
                    top = top.next;
                }
            }
            return top;
        }

        private boolean flipCoin() {
            return rand.nextDouble() < 0.5;
        }
    }
}
