import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S0145BinaryTreePostorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode dummy = new TreeNode(0);
        dummy.left = new TreeNode(0);
        dummy.right = root;
        Stack<TreeNode> d = new Stack<>();
        d.push(dummy);
        d.push(dummy.left);
        Stack<Stack<TreeNode>> stacks = new Stack<>();
        stacks.push(d);

        do {
            Stack<TreeNode> outer = stacks.pop();
            res.add(outer.pop().val);
            if (outer.isEmpty()) {
                continue;
            }
            stacks.push(outer);
            if (outer.peek().right == null) {
                continue;
            }
            TreeNode n = outer.peek().right;
            Stack<TreeNode> t = new Stack<>();
            t.push(n);
            while (true) {
                if (n.left != null) {
                    t.push(n.left);
                    n = n.left;
                    continue;
                }
                if (n.right != null) {
                    stacks.push(t);
                    t = new Stack<>();
                    t.push(n.right);
                    n = n.right;
                    continue;
                }
                break;
            }
            stacks.push(t);
        } while (!stacks.isEmpty());

        res.remove(0);
        res.remove(res.size()-1);
        return res;

//        if (root.left != null) {
//            res.addAll(postorderTraversal(root.left));
//        }
//        if (root.right != null) {
//            res.addAll(postorderTraversal(root.right));
//        }
//        res.add(root.val);
    }
}
