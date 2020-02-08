import util.TreeNode;

public class S0988SmallestStringStartingFromLeaf {
    String candidate = null;

    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }
        return smallest(root, new StringBuilder());
    }

    private String smallest(TreeNode root, StringBuilder sb) {
        assert root != null;
        char c = (char)(root.val+'a');
        if (root.left == null && root.right == null) {
            return sb.append(c).reverse().toString();
        } else if (root.left == null) {
            sb.append(c);
            return smallest(root.right, sb);
        } else if (root.right == null) {
            sb.append(c);
            return smallest(root.left, sb);
        } else {
            sb.append(c);
            String left = smallest(root.left, new StringBuilder(sb));
            String right = smallest(root.right, new StringBuilder(sb));
            if (left.compareTo(right) <= 0) {
                return left;
            } else {
                return right;
            }
        }
    }
}
