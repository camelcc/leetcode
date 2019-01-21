import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0662MaximumWidthBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1;

        List<TreeNode> level = new ArrayList<>();
        HashMap<TreeNode, Integer> index = new HashMap<>();
        level.add(root);
        index.put(root, 1);

        while (!level.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();
            HashMap<TreeNode, Integer> nextIndex = new HashMap<>();

            for (TreeNode n : level) {
                if (n.left != null) {
                    nextLevel.add(n.left);
                    nextIndex.put(n.left, index.get(n)*2);
                }
                if (n.right != null) {
                    nextLevel.add(n.right);
                    nextIndex.put(n.right, index.get(n)*2+1);
                }
            }

            if (!nextLevel.isEmpty()) {
                int first = nextIndex.get(nextLevel.get(0));
                int end = nextIndex.get(nextLevel.get(nextLevel.size()-1));
                res = Math.max(res, end-first+1);
            }

            level = nextLevel;
            index = nextIndex;
        }

        return res;
    }
}
