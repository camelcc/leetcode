public class S0138CopyListRandomPointer {
    class Node {
        int val;
        Node next, random;

        Node(int x) {
            this.val= x;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node node = head;
        while (node != null) {
            Node clone = new Node(node.val);
            clone.next = node.next;
            node.next = clone;
            node = node.next.next;
        }

        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }

            node = node.next.next;
        }

        Node res = new Node(0);
        Node tail = res;
        node = head;
        while (node != null) {
            tail.next = node.next;
            tail = node.next;

            node.next = node.next.next;
            node = node.next;
        }
        return res.next;
    }
}
