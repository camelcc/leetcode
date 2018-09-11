public class S0558QuadTreeIntersection {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    public Node intersect(Node quadTree1, Node quadTree2) {
        Node tl, tr, bl, br;
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            return new Node(quadTree1.val | quadTree2.val, true, null, null, null, null);
        } else if (quadTree1.isLeaf) {
            tl = intersect(quadTree1, quadTree2.topLeft);
            tr = intersect(quadTree1, quadTree2.topRight);
            bl = intersect(quadTree1, quadTree2.bottomLeft);
            br = intersect(quadTree1, quadTree2.bottomRight);
        } else if (quadTree2.isLeaf) {
            tl = intersect(quadTree1.topLeft, quadTree2);
            tr = intersect(quadTree1.topRight, quadTree2);
            bl = intersect(quadTree1.bottomLeft, quadTree2);
            br = intersect(quadTree1.bottomRight, quadTree2);
        } else {
            tl = intersect(quadTree1.topLeft, quadTree2.topLeft);
            tr = intersect(quadTree1.topRight, quadTree2.topRight);
            bl = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            br = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        }

        if (tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf && tl.val == tr.val && tr.val == bl.val && bl.val == br.val) {
            return new Node(tl.val, true, null, null, null, null);
        } else {
            return new Node(quadTree1.val | quadTree2.val, false, tl, tr, bl, br);
        }
    }
}
