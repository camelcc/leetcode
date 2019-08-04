public class S1145BinaryTreeColoringGame {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int[] cnt = new int[n+1];
        int total = cnt(root, cnt);
        int[] search = search(root, x);
        assert search != null;
        if (search[0] != 0) {
            if (total-cnt[x] > cnt[x]) {
                return true;
            }
        }
        if (search[1] != 0) {
            if (cnt[search[1]] > total-cnt[search[1]]) {
                return true;
            }
        }
        if (search[2] != 0) {
            if (cnt[search[2]] > total-cnt[search[2]]) {
                return true;
            }
        }
        return false;
    }

    private int cnt(TreeNode root, int[] cnt) {
        if (root == null) {
            return 0;
        }
        int res = 1 + cnt(root.left, cnt) + cnt(root.right, cnt);
        cnt[root.val] = res;
        return res;
    }

    private int[] search(TreeNode root, int x) {
        if (root == null) {
            return null;
        }
        if (root.val == x) {
            return new int[]{0, root.left == null ? 0 : root.left.val, root.right == null ? 0 : root.right.val};
        }
        int[] left = search(root.left, x);
        if (left != null) {
            if (root.left.val == x) {
                left[0] = root.val;
            }
            return left;
        }
        int[] right = search(root.right, x);
        if (right != null) {
            if (root.right.val == x) {
                right[0] = root.val;
            }
            return right;
        }
        return null;
    }
}
