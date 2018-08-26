public class S0430FlattenMultilevelDoublyLinkedList {
    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }

        Node h = null;
        Node tail = null;

        Node n = head;
        while (n != null) {
            if (h == null) {
                h = new Node(n.val, null, null, null);
                tail = h;
            } else {
                tail.next = new Node(n.val, tail, null, null);
                tail = tail.next;
            }

            if (n.child != null) {
                Node c = flatten(n.child);
                while (c != null) {
                    tail.next = new Node(c.val, tail, null, null);
                    tail = tail.next;
                    c = c.next;
                }
            }

            n = n.next;
        }
        return h;
    }
}
