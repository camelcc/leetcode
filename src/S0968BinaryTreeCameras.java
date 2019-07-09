public class S0968BinaryTreeCameras {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.val > 0) {
            return root.val;
        }

        int cnt = Integer.MAX_VALUE;
        // root
        int r = 1;
        if (root.left != null) {
            r += Math.min(minCameraCover(root.left),
                    minCameraCover(root.left.left) +
                            minCameraCover(root.left.right));
        }
        if (root.right != null) {
            r += Math.min(minCameraCover(root.right),
                    minCameraCover(root.right.left) +
                            minCameraCover(root.right.right));
        }
        cnt = Math.min(cnt, r);

        // left
        if (root.left != null) {
            int left = 1;
            left += minCameraCover(root.right);
            if (root.left.left != null) {
                left += Math.min(minCameraCover(root.left.left),
                        minCameraCover(root.left.left.left) +
                                minCameraCover(root.left.left.right));
            }
            if (root.left.right != null) {
                left += Math.min(minCameraCover(root.left.right),
                        minCameraCover(root.left.right.left) +
                                minCameraCover(root.left.right.right));
            }
            cnt = Math.min(cnt, left);
        }

        // right
        if (root.right != null) {
            int right = 1;
            right += minCameraCover(root.left);
            if (root.right.left != null) {
                right += Math.min(minCameraCover(root.right.left),
                        minCameraCover(root.right.left.left) +
                                minCameraCover(root.right.left.right));
            }
            if (root.right.right != null) {
                right += Math.min(minCameraCover(root.right.right),
                        minCameraCover(root.right.right.left) +
                                minCameraCover(root.right.right.right));
            }
            cnt = Math.min(cnt, right);
        }
        root.val = cnt;
        return cnt;
    }
}
