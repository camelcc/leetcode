import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S0113PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> a = new ArrayList<>();
                a.add(root.val);
                res.add(a);
            }
            return res;
        }

        int val = sum - root.val;
        if (root.left != null) {
            for (List<Integer> path : pathSum(root.left, val)) {
                path.add(0, root.val);
                res.add(path);
            }
        }

        if (root.right != null) {
            for (List<Integer> path : pathSum(root.right, val)) {
                path.add(0, root.val);
                res.add(path);
            }
        }
        return res;
    }
}
