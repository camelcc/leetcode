import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0508MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        HashMap<Integer, Integer> counts = new HashMap<>();
        sum(root, counts);
        int highest = 0;
        for (int c : counts.values()) {
            if (highest < c) {
                highest = c;
            }
        }
        List<Integer> sum = new ArrayList<>();
        for (int s : counts.keySet()) {
            if (counts.get(s) == highest) {
                sum.add(s);
            }
        }
        int[] res = new int[sum.size()];
        for (int i = 0; i < sum.size(); i++) {
            res[i] = sum.get(i);
        }
        return res;
    }

    private int sum(TreeNode root, HashMap<Integer, Integer> count) {
        if (root.left == null && root.right == null) {
            if (count.containsKey(root.val)) {
                count.put(root.val, count.get(root.val) + 1);
            } else {
                count.put(root.val, 1);
            }
            return root.val;
        }

        if (root.left == null) {
            int s = sum(root.right, count) + root.val;
            if (count.containsKey(s)) {
                count.put(s, count.get(s) + 1);
            } else {
                count.put(s, 1);
            }
            return s;
        }

        if (root.right == null) {
            int s = sum(root.left, count) + root.val;
            if (count.containsKey(s)) {
                count.put(s, count.get(s) + 1);
            } else {
                count.put(s, 1);
            }
            return s;
        }

        int s = sum(root.left, count) + sum(root.right, count) + root.val;
        if (count.containsKey(s)) {
            count.put(s, count.get(s) + 1);
        } else {
            count.put(s, 1);
        }
        return s;
    }
}
