public class S1261FindElementsContaminatedBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static class FindElements {
        private TreeNode root;

        public FindElements(TreeNode root) {
            this.root = root;
            if (root == null) {
                return;
            }
            setVal(root, 0);
        }

        private void setVal(TreeNode node, int v) {
            node.val = v;
            if (node.left != null) {
                setVal(node.left, 2*v+1);
            }
            if (node.right != null) {
                setVal(node.right, 2*v+2);
            }
        }

        public boolean find(int target) {
            return findNode(target) != null;
        }

        private TreeNode findNode(int target) {
            if (target < 0 || root == null) {
                return null;
            }
            if (target == 0) {
                return root;
            }
            // target > 0
            if (target%2 == 0) { // right
                int t = (target-2)/2;
                TreeNode node = findNode(t);
                if (node != null && node.right != null) {
                    return node.right;
                } else {
                    return null;
                }
            } else { // left
                int t = (target-1)/2;
                TreeNode node = findNode(t);
                if (node != null && node.left != null) {
                    return node.left;
                } else {
                    return null;
                }
            }
        }
    }

}
