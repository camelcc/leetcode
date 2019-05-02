import java.util.HashMap;

public class S0146LRUCache {
    public static class LRUCache {
        private class Node {
            int key;
            int value;
            Node next;
            Node prev;

            Node(Node prev, int key, int value, Node next) {
                this.key = key;
                this.value = value;
                this.next = next;
                this.prev = prev;
            }
        }

        private Node head = new Node(null, 0, 0, null);
        private Node tail = head;
        private HashMap<Integer, Node> map = new HashMap<>();
        private int SIZE = 0;

        public LRUCache(int capacity) {
            this.SIZE = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            Node node = map.get(key);
            if (node == tail) {
                return node.value;
            }

            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.next = null;
            tail.next = node;
            node.prev = tail;
            tail = node;
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.get(key).value = value;
                get(key);
                return;
            }

            if (map.size() == SIZE) {
                Node d = head.next;
                head.next = d.next;
                if (d.next != null) {
                    d.next.prev = head;
                }
                if (d == tail) {
                    tail = head;
                }
                map.remove(d.key);
            }
            Node node = new Node(tail, key, value, null);
            tail.next = node;
            tail = node;
            map.put(key, node);
        }
    }
}
