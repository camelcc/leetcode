import util.TreeNode;

import java.util.Stack;

public class S0173BSTIterator {
    // time - O(1), space - O(h)
    public class BSTIterator {
        Stack<TreeNode> path = new Stack<>();

        public BSTIterator(TreeNode root) {
            TreeNode n = root;
            while (n != null) {
                path.push(n);
                n = n.left;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !path.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode n = path.pop();
            // add right tree if exist
            TreeNode r = n.right;
            while (r != null) {
                path.push(r);
                r = r.left;
            }
            return n.val;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
