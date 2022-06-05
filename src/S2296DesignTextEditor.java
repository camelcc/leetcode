public class S2296DesignTextEditor {
    public static class TextEditor {
        class Node {
            Node prev, next;
            String text;

            Node(String t) {
                text = t;
            }
        }

        Node head, cursor;

        public TextEditor() {
            head = new Node("");
            cursor = new Node("");
            head.next = cursor;
            cursor.prev = head;
        }

        public void addText(String text) {
            Node node = new Node(text);
            node.prev = cursor.prev;
            cursor.prev.next = node;

            node.next = cursor;
            cursor.prev = node;
        }

        public int deleteText(int k) {
            if (cursor.prev == head || k == 0) {
                return 0;
            }

            Node n = cursor.prev;
            if (n.text.length() > k) {
                n.text = n.text.substring(0, n.text.length()-k);
                return k;
            } else if (n.text.length() == k) {
                cursor.prev.prev.next = cursor;
                cursor.prev = cursor.prev.prev;
                return k;
            } else { // n.text.len < k
                cursor.prev.prev.next = cursor;
                cursor.prev = cursor.prev.prev;

                int deleted = n.text.length();
                return deleted + deleteText(k-deleted);
            }
        }

        public String cursorLeft(int k) {
            moveLeft(k);
            return buffer();
        }

        private String buffer() {
            StringBuilder res = new StringBuilder();
            Node n = cursor.prev;
            while (n != head && res.length() <= 10) {
                res.insert(0, n.text);
                n = n.prev;
            }

            if (res.length() > 10) {
                res = new StringBuilder(res.substring(res.length() - 10));
            }
            return res.toString();
        }

        private void moveLeft(int k) {
            if (cursor.prev == head || k == 0) {
                return;
            }

            Node n = cursor.prev;
            if (n.text.length() > k) {
                String res = n.text.substring(n.text.length()-k);
                Node newNode = new Node(res);
                newNode.next = cursor;
                cursor.prev = newNode;
                newNode.prev = n;
                n.next = newNode;
                n.text = n.text.substring(0, n.text.length()-k);
                cursor = newNode;
                return;
            } else if (n.text.length() == k) {
                cursor = n;
                return;
            }

            // n.text.len < k
            cursor = n;
            moveLeft(k-n.text.length());
        }

        private void moveRight(int k) {
            if (k == 0 || cursor.text.isEmpty()) {
                return;
            }

            Node n = cursor;
            if (n.text.length() > k) {
                String res = n.text.substring(k);
                Node newNode = new Node(res);
                newNode.next = n.next;
                n.next.prev = newNode;
                newNode.prev = n;
                n.next = newNode;
                cursor = newNode;
                n.text = n.text.substring(0, k);
                return;
            } else if (n.text.length() == k) {
                cursor = n.next;
                return;
            }

            cursor = n.next;
            moveRight(k-n.text.length());
        }

        public String cursorRight(int k) {
            moveRight(k);
            return buffer();
        }
    }
}
