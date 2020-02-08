import util.TreeNode;

public class S0606ConstructStringBinaryTree {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        travel(t, sb);
        return sb.toString();
    }

    private void travel(TreeNode t, StringBuilder sb) {
        sb.append(String.valueOf(t.val));
        if (t.left == null && t.right == null) {
            return;
        }
        if (t.left == null) {
            sb.append("()");
        } else {
            sb.append("(");
            travel(t.left, sb);
            sb.append(")");
        }
        if (t.right != null) {
            sb.append("(");
            travel(t.right, sb);
            sb.append(")");
        }
    }
}
