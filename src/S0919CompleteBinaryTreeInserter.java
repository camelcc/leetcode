import java.util.LinkedList;
import java.util.Queue;

public class S0919CompleteBinaryTreeInserter {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class CBTInserter {
        private TreeNode root;
        private Queue<TreeNode> brokenParent;
        private Queue<TreeNode> leaf;

        public CBTInserter(TreeNode root) {
            this.root = root;
            brokenParent = new LinkedList<>();
            leaf = new LinkedList<>();
            if (root.left == null || root.right == null) {
                if (root.left != null) {
                    leaf.offer(root.left);
                }
                brokenParent.offer(root);
                return;
            }

            leaf.add(root);
            boolean full = true;
            while (full) {
                brokenParent = leaf;
                Queue<TreeNode> children = new LinkedList<>();
                for (TreeNode p : brokenParent) {
                    if (p.left != null) {
                        children.offer(p.left);
                    } else {
                        full = false;
                        break;
                    }
                    if (p.right != null) {
                        children.offer(p.right);
                    } else {
                        full = false;
                        break;
                    }
                }
                leaf = children;
            }
            while (!brokenParent.isEmpty() &&
                    brokenParent.peek().left != null &&
                    brokenParent.peek().right != null) {
                brokenParent.poll();
            }
        }

        public int insert(int v) {
            assert !brokenParent.isEmpty();
            TreeNode n = new TreeNode(v);
            leaf.offer(n);

            if (brokenParent.peek().left != null) {
                assert brokenParent.peek().right == null;
                TreeNode t = brokenParent.poll();
                t.right = n;

                if (brokenParent.isEmpty()) {
                    brokenParent = leaf;
                    leaf = new LinkedList<>();
                }
                return t.val;
            } else {
                brokenParent.peek().left = n;
                return brokenParent.peek().val;
            }
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
