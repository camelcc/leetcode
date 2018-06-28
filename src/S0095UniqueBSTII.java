import java.util.ArrayList;
import java.util.List;

public class S0095UniqueBSTII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i-1] = i;
        }
        return gen(nums);
    }

    private List<TreeNode> gen(int[] nums) {
        List<TreeNode> forest = new ArrayList<>();
        if (nums.length == 0) {
            return forest;
        }
        if (nums.length == 1) {
            TreeNode root = new TreeNode(nums[0]);
            forest.add(root);
            return forest;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                List<TreeNode> rights = gen(right(nums, i));
                for (TreeNode r : rights) {
                    TreeNode root = new TreeNode(nums[i]);
                    root.right = r;
                    forest.add(root);
                }
            } else if (i == nums.length-1) {
                List<TreeNode> lefts = gen(left(nums, i));
                for (TreeNode l : lefts) {
                    TreeNode root = new TreeNode(nums[i]);
                    root.left = l;
                    forest.add(root);
                }
            } else {
                List<TreeNode> lefts = gen(left(nums, i));
                List<TreeNode> rights = gen(right(nums, i));
                for (TreeNode l : lefts) {
                    for (TreeNode r : rights) {
                        TreeNode root = new TreeNode(nums[i]);
                        root.left = l;
                        root.right = r;
                        forest.add(root);
                    }
                }
            }
        }

        return forest;
    }

    private int[] left(int[] nums, int p) {
        int[] res = new int[p];
        for (int i = 0; i < p; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    private int[] right(int[] nums, int p) {
        int[] res = new int[nums.length-p-1];
        for (int i = p+1, k = 0; i < nums.length; i++) {
            res[k++] = nums[i];
        }
        return res;
    }
}
