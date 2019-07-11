import java.util.*;

public class S0987VerticalOrderTraversalBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, TreeSet<Integer>>> res = new TreeMap<>();
        travel(root, 0, 0, res);
        List<List<Integer>> r = new ArrayList<>(res.size());
        for (TreeMap<Integer, TreeSet<Integer>> l : res.values()) {
            List<Integer> v = new ArrayList<>();
            for (TreeSet<Integer> n : l.values()) {
                v.addAll(n);
            }
            r.add(v);
        }
        return r;
    }

    private void travel(TreeNode root, int x, int y,
                        TreeMap<Integer, TreeMap<Integer, TreeSet<Integer>>> tree) {
        if (root == null) {
            return;
        }
        tree.putIfAbsent(x, new TreeMap<>(Comparator.reverseOrder()));
        tree.get(x).putIfAbsent(y, new TreeSet<>());
        tree.get(x).get(y).add(root.val);
        travel(root.left, x-1, y-1, tree);
        travel(root.right, x+1, y-1, tree);
    }
}
