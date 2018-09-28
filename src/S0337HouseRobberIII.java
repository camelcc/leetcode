import java.util.HashMap;

public class S0337HouseRobberIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private HashMap<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }

        int max = 0;
        // rob root
        int robRoot = root.val;
        if (root.left != null) {
            robRoot += rob(root.left.left);
            robRoot += rob(root.left.right);
        }
        if (root.right != null) {
            robRoot += rob(root.right.left);
            robRoot += rob(root.right.right);
        }

        // not rot root
        int notRobRoot = 0;
        if (root.left != null) {
            notRobRoot += rob(root.left);
        }
        if (root.right != null) {
            notRobRoot += rob(root.right);
        }

        max = Math.max(robRoot, notRobRoot);

        map.put(root, max);
        return max;
    }
}
