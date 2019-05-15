import java.util.HashMap;
import java.util.HashSet;

public class S0432AllOoneDataStructure {
    public static class AllOne {
        private class Node {
            int val;
            Node prev;
            Node next;
            HashSet<String> keys;

            public Node(int val) {
                this.val = val;
                this.keys = new HashSet<>();
            }
        }

        private Node head = null;
        private Node tail = null;
        private HashMap<String, Node> map = null;

        public AllOne() {
            head = new Node(0);
            map = new HashMap<>();
            tail = head;
        }

        public void inc(String key) {
            Node node = map.remove(key);
            if (node == null) {
                if (head.next != null && head.next.val == 1) {
                    node = head.next;
                } else {
                    node = new Node(1);
                    node.prev = head;
                    node.next = head.next;
                    if (tail == head) {
                        tail = node;
                    }
                    if (head.next != null) {
                        head.next.prev = node;
                    }
                    head.next = node;
                }
                node.keys.add(key);
                map.put(key, node);
                return;
            }

            if (node.next != null && node.next.val == node.val+1) {
                node.next.keys.add(key);
                map.put(key, node.next);
            } else {
                Node res = new Node(node.val + 1);
                res.keys.add(key);
                res.prev = node;
                res.next = node.next;
                if (tail == node) {
                    tail = res;
                }
                if (node.next != null) {
                    node.next.prev = res;
                }
                node.next = res;
                map.put(key, res);
            }

            // delete key from node
            node.keys.remove(key);
            if (!node.keys.isEmpty()) {
                return;
            }
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        public void dec(String key) {
            Node node = map.remove(key);
            if (node == null) {
                return;
            }
            if (node.val == 1) {
                node.keys.remove(key);
                if (!node.keys.isEmpty()) {
                    map.put(key, node);
                    return;
                }
                // delete node
                if (tail == node) {
                    tail = node.prev;
                }
                if (node.next != null) {
                    node.next.prev = node.prev;
                }
                node.prev.next = node.next;
                return;
            }

            // node.val > 1
            if (node.prev.val+1 == node.val) {
                node.prev.keys.add(key);
                map.put(key, node.prev);
            } else {
                Node res = new Node(node.val-1);
                res.keys.add(key);
                res.prev = node.prev;
                res.next = node;
                node.prev.next = res;
                node.prev = res;
                map.put(key, res);
            }

            // delete key from node
            node.keys.remove(key);
            if (!node.keys.isEmpty()) {
                return;
            }
            if (node == tail) {
                tail = node.prev;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            node.prev.next = node.next;
        }

        public String getMaxKey() {
            if (tail.prev != null) {
                assert !tail.keys.isEmpty();
                return tail.keys.iterator().next();
            }
            return "";
        }

        public String getMinKey() {
            if (head.next != null) {
                assert !head.next.keys.isEmpty();
                return head.next.keys.iterator().next();
            }
            return "";
        }
    }
}
