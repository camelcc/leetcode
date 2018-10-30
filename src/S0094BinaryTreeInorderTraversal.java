import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S0094BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode n = root;
        while (n != null) {
            stack.push(n);
            n = n.left;
        }

        while (!stack.isEmpty()) {
            n = stack.pop();
            res.add(n.val);
            n = n.right;
            while (n != null) {
                stack.push(n);
                n = n.left;
            }
        }
        return res;
    }
}
