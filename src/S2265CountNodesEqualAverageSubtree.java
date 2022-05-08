import util.TreeNode;

public class S2265CountNodesEqualAverageSubtree {
    public int averageOfSubtree(TreeNode root) {
        int[] res = average(root);
        return res[0];
    }

    public int[] average(TreeNode root) {
        int res = 0, sum = root.val, cnt = 1;
        if (root.left != null) {
            int[] left = average(root.left);
            res += left[0];
            sum += left[1];
            cnt += left[2];
        }
        if (root.right != null) {
            int[] right = average(root.right);
            res += right[0];
            sum += right[1];
            cnt += right[2];
        }
        int ag = sum/cnt;
        if (root.val == ag) {
            res++;
        }
        return new int[]{res, sum, cnt};
    }
}
