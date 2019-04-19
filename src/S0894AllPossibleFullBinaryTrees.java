import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0894AllPossibleFullBinaryTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    HashMap<Integer, List<TreeNode>> dp = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if (dp.containsKey(N)) {
            return dp.get(N);
        }

        List<TreeNode> res = new ArrayList<>();
        if (N == 0 || N == 2) {
        } else if (N == 1) {
            res.add(new TreeNode(0));
        } else {
            int left = 1, right = N-2;
            while (left < N-1 && right > 0) {
                List<TreeNode> l = allPossibleFBT(left);
                List<TreeNode> r = allPossibleFBT(right);
                for (TreeNode tl : l) {
                    for (TreeNode tr : r) {
                        TreeNode root = new TreeNode(0);
                        root.left = clone(tl);
                        root.right = clone(tr);
                        res.add(root);
                    }
                }
                left++;
                right--;
            }
        }
        dp.put(N, res);
        return res;
    }

    private TreeNode clone(TreeNode tree) {
        if (tree == null) {
            return null;
        }
        TreeNode res = new TreeNode(tree.val);
        res.left = clone(tree.left);
        res.right = clone(tree.right);
        return res;
    }
}
