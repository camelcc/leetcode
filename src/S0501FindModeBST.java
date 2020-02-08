import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0501FindModeBST {
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        countMode(root, counts);

        List<Integer> modes = new ArrayList<>();
        int modeCount = 0;

        for (Integer val : counts.keySet()) {
            if (counts.get(val) < modeCount) {
                // do nothing
            } else if (counts.get(val) == modeCount) {
                modes.add(val);
            } else {
                modes.clear();
                modes.add(val);
                modeCount = counts.get(val);
            }
        }
        int[] res = new int[modes.size()];
        int i = 0;
        for (Integer val : modes) {
            res[i++] = val;
        }
        return res;
    }

    public void countMode(TreeNode root, HashMap<Integer, Integer> st) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            countMode(root.left, st);
        }
        if (st.containsKey(root.val)) {
            st.put(root.val, st.get(root.val)+1);
        } else {
            st.put(root.val, 1);
        }
        if (root.right != null) {
            countMode(root.right, st);
        }
    }
}
