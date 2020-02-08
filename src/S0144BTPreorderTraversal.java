import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S0144BTPreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<TreeNode> stack = new ArrayList<>();
        stack.add(root);
        do {
            TreeNode node = stack.remove(stack.size()-1);
            while (node != null) {
                res.add(node.val);
                if (node.right != null) {
                    stack.add(node.right);
                }
                // left
                node = node.left;
            }
        } while (!stack.isEmpty());
        return res;
    }
}
