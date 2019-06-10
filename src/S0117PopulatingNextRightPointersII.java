public class S0117PopulatingNextRightPointersII {
    public class Node {
        int val;
        Node left, right, next;

        Node(int x) {
            val = x;
        }
    }

    public Node connect(Node root) {
        Node res = root;
        Node tmp = new Node(0);
        while (root != null) {
            Node pre = tmp;
            while (root != null) {
                if (root.left != null) {
                    pre.next = root.left;
                    pre = pre.next;
                }
                if (root.right != null) {
                    pre.next = root.right;
                    pre = pre.next;
                }
                root = root.next;
            }
            root = tmp.next;
            tmp.next = null;
        }
        return res;
    }
}
