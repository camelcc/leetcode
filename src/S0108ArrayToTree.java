import util.TreeNode;

public class S0108ArrayToTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return generateTree(nums, 0, nums.length-1);
    }

    private TreeNode generateTree(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        if (lo == hi) {
            return new TreeNode(nums[lo]);
        }

        int mid = (lo+hi)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = generateTree(nums, lo, mid-1);
        root.right = generateTree(nums, mid+1, hi);
        return root;
    }
}
