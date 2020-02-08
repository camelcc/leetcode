import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S0095UniqueBSTII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<TreeNode>[] dp = new ArrayList[n+1];
        dp[0] = new ArrayList<>();
        dp[0].add(null);

        for (int len = 1; len <= n; len++) {
            List<TreeNode> res = new ArrayList<>();
            for (int left = 0; left < len; left++) {
                for (TreeNode l : dp[left]) {
                    for (TreeNode r : dp[len-left-1]) {
                        TreeNode node = new TreeNode(left+1);
                        node.left = l;
                        node.right = clone(r, left+1);
                        res.add(node);
                    }
                }
            }
            dp[len] = res;
        }
        return dp[n];
    }

    private TreeNode clone(TreeNode node, int offset) {
        if (node == null) {
            return null;
        }
        TreeNode res = new TreeNode(node.val+offset);
        res.left = clone(node.left, offset);
        res.right = clone(node.right, offset);
        return res;
    }
}
