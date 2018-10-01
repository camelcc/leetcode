public class S0707DesignLinkedList {
    class MyLinkedList {
        private class Node {
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        private Node head;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            head = null;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if (head == null) {
                return -1;
            }
            int c = 0;
            Node n = head;
            while (c < index && n != null) {
                n = n.next;
                c++;
            }
            return n == null ? -1 : n.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            if (head == null) {
                head = new Node(val);
                return;
            }

            Node h = new Node(val);
            h.next = head;
            head = h;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            if (head == null) {
                head = new Node(val);
                return;
            }

            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = new Node(val);
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (head == null) {
                if (index == 0) {
                    head = new Node(val);
                }
                return;
            }

            Node c = null;
            Node n = head;
            int i = 0;
            while (i < index && n != null) {
                c = n;
                n = n.next;
                i++;
            }
            if (i < index) {
                return;
            }

            if (c == null) { // head
                head = new Node(val);
                head.next = n;
                return;
            }

            c.next = new Node(val);
            c.next.next = n;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (head == null || index < 0) {
                return;
            }
            if (index == 0) {
                head = head.next;
                return;
            }

            Node c = null;
            Node n = head;
            int i = 0;
            while (i < index && n != null) {
                c = n;
                n = n.next;
                i++;
            }
            if (i < index) {
                return;
            }

            c.next = (n == null ? null : n.next);
        }
    }
}
