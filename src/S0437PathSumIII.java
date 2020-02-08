import util.TreeNode;

import java.util.HashMap;

public class S0437PathSumIII {
    private HashMap<Integer, Integer> preSum = new HashMap<>();

    public int pathSum(TreeNode root, int sum) {
        preSum.put(0, 1);
        return pathSum(root, 0, sum);
    }

    private int pathSum(TreeNode root, int sum, int target) {
        if (root == null) {
            return 0;
        }

        int count = preSum.getOrDefault(sum+root.val-target, 0);

        int s = sum + root.val;
        preSum.put(s, preSum.getOrDefault(s, 0) + 1);

        count += pathSum(root.left, s, target);
        count += pathSum(root.right, s, target);
        preSum.put(s, preSum.getOrDefault(s, 0) - 1);
        return count;
    }
}
