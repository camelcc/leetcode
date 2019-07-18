public class S1028RecoverTreeFromPreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode recoverFromPreorder(String S) {
        TreeNode t = new TreeNode(0);
        build(S, 0, 0, t, true);
        return t.left;
    }

    private int build(String S, int pos, int depth, TreeNode root, boolean left) {
        if (pos >= S.length()) {
            return pos;
        }
        int p = pos;

        int d = 0;
        while (pos < S.length() && S.charAt(pos) == '-') {
            d++;
            pos++;
        }
        if (d < depth) {
            return p;
        }
        assert d == depth;
        assert pos < S.length();

        // left
        int v = 0;
        while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
            v = v * 10 + (S.charAt(pos)-'0');
            pos++;
        }
        TreeNode res = new TreeNode(v);
        pos = build(S, pos, d+1, res, true);
        pos = build(S, pos, d+1, res, false);
        if (left) {
            root.left = res;
        } else {
            root.right = res;
        }
        return pos;
    }
}
