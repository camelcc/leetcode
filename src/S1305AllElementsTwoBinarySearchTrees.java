import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S1305AllElementsTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        TreeNode t = root1;
        Stack<TreeNode> stack1 = new Stack<>();
        while (t != null) {
            stack1.push(t);
            t = t.left;
        }
        t = root2;
        Stack<TreeNode> stack2 = new Stack<>();
        while (t != null) {
            stack2.push(t);
            t = t.left;
        }

        List<Integer> res = new ArrayList<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                TreeNode n = stack2.pop();
                res.add(n.val);
                n = n.right;
                while (n != null) {
                    stack2.push(n);
                    n = n.left;
                }
            } else if (stack2.isEmpty()) {
                TreeNode n = stack1.pop();
                res.add(n.val);
                n = n.right;
                while (n != null) {
                    stack1.push(n);
                    n = n.left;
                }
            } else {
                TreeNode n1 = stack1.pop(), n2 = stack2.pop();
                if (n1.val < n2.val) {
                    stack2.push(n2);
                    res.add(n1.val);
                    TreeNode n = n1.right;
                    while (n != null) {
                        stack1.push(n);
                        n = n.left;
                    }
                } else if (n1.val == n2.val) {
                    res.add(n1.val);
                    res.add(n2.val);
                    TreeNode n = n1.right;
                    while (n != null) {
                        stack1.push(n);
                        n = n.left;
                    }
                    n = n2.right;
                    while (n != null) {
                        stack2.push(n);
                        n = n.left;
                    }
                } else if (n1.val > n2.val) {
                    stack1.push(n1);
                    res.add(n2.val);
                    TreeNode n = n2.right;
                    while (n != null) {
                        stack2.push(n);
                        n = n.left;
                    }
                }
            }
        }
        return res;
    }
}
