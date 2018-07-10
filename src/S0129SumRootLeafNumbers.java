import java.util.ArrayList;
import java.util.List;

public class S0129SumRootLeafNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        List<String> nums = new ArrayList<>();
        traveral(root, "", nums);
        int sum = 0;
        for (String n : nums) {
            sum += Integer.valueOf(n);
        }
        return sum;
    }

    private void traveral(TreeNode root, String pre, List<String> nums) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            nums.add(pre + root.val);
        }

        if (root.left != null) {
            traveral(root.left, pre+root.val, nums);
        }
        if (root.right != null) {
            traveral(root.right, pre+root.val, nums);
        }
    }
}
