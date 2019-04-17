import java.util.Arrays;
import java.util.HashMap;

public class S0889ConstructBinaryTreePreorderPostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[0]);
        if (pre.length == 1) {
            return root;
        }

        HashMap<Integer, Integer> count = new HashMap<>();
        int preLeft = 0;
        int postLeft = 0;
        while (postLeft < post.length-1) {
            preLeft++;
            count.put(pre[preLeft], count.getOrDefault(pre[preLeft], 0)+1);
            if (count.get(pre[preLeft]) == 0) {
                count.remove(pre[preLeft]);
            }
            count.put(post[postLeft], count.getOrDefault(post[postLeft], 0)-1);
            if (count.get(post[postLeft]) == 0) {
                count.remove(post[postLeft]);
            }
            if (count.isEmpty()) {
                root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, preLeft+1),
                        Arrays.copyOfRange(post, 0, postLeft+1));
                break;
            } else {
                postLeft++;
            }
        }
        int preRight = preLeft+1;
        if (preRight < pre.length) {
            root.right = constructFromPrePost(Arrays.copyOfRange(pre, preRight, pre.length),
                    Arrays.copyOfRange(post, postLeft+1, post.length));
        }

        return root;
    }
}
