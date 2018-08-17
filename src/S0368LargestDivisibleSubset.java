import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//TODO: DP solution
public class S0368LargestDivisibleSubset {
    public static class TreeNode {
        int val;
        int height;
        List<TreeNode> nodes;

        public TreeNode(int val) {
            this.val = val;
            this.nodes = new ArrayList<>();
            this.height = 1;
        }
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<TreeNode> subsets = new ArrayList<>();

        for (int num : nums) {
            boolean added = false;
            for (TreeNode node : subsets) {
                if (num % node.val == 0) {
                    addNumToTreeNode(node, num);
                    added = true;
                }
            }

            if (!added) {
                TreeNode subset = new TreeNode(num);
                subsets.add(subset);
            }
        }

        subsets.sort(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o2.height - o1.height;
            }
        });
        TreeNode s = subsets.get(0);
        List<Integer> res = new ArrayList<>();
        while (s != null) {
            res.add(s.val);
            if (s.nodes.isEmpty()) {
                break;
            }

            TreeNode t = s.nodes.get(0);
            for (int i = 1; i < s.nodes.size(); i++) {
                if (s.nodes.get(i).height > t.height) {
                    t = s.nodes.get(i);
                }
            }
            s = t;
        }
        return res;
    }

    private void addNumToTreeNode(TreeNode root, int num) {
        assert num % root.val == 0;
        if (root.nodes.isEmpty()) {
            root.height++;
            root.nodes.add(new TreeNode(num));
            return;
        }

        boolean added = false;
        int maxHeight = 0;
        for (TreeNode child : root.nodes) {
            if (num % child.val == 0) {
                added = true;
                addNumToTreeNode(child, num);
            }
            if (maxHeight < child.height) {
                maxHeight = child.height;
            }
        }

        if (added) {
            root.height = maxHeight + 1;
        } else {
            root.nodes.add(new TreeNode(num));
        }
    }
}
