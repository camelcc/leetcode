import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class S2096StepByStepDirectionsFromBinaryTreeNodeAnother {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<Character> start = path(root, new ArrayList<>(), startValue);
        List<Character> end = path(root, new ArrayList<>(), destValue);
        int i = 0;
        while (i < start.size() && i < end.size() && start.get(i) == end.get(i)) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < start.size(); j++) {
            sb.append('U');
        }
        for (int j = i; j < end.size(); j++) {
            sb.append(end.get(j));
        }
        return sb.toString();
    }

    private List<Character> path(TreeNode node, List<Character> path, int value) {
        if (node.val == value) {
            return path;
        }
        if (node.left != null) {
            path.add('L');
            List<Character> l = path(node.left, path, value);
            if (l != null) {
                return l;
            }
            path.remove(path.size()-1);
        }
        if (node.right != null) {
            path.add('R');
            List<Character> r = path(node.right, path, value);
            if (r != null) {
                return r;
            }
            path.remove(path.size()-1);
        }
        return null;
    }
}
