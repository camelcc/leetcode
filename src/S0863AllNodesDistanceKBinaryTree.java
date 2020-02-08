import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class S0863AllNodesDistanceKBinaryTree {
    class Solution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int index = buildMap(root, 1, target.val, map);
            HashSet<Integer> visited = new HashSet<>();
            List<Integer> res = new ArrayList<>();
            if (K == 0) {
                res.add(map.get(index));
                return res;
            }

            List<int[]> bfs = new ArrayList<>();
            bfs.add(new int[]{index, 0});
            while (!bfs.isEmpty()) {
                int[] b = bfs.remove(0);
                int nodeIndex = b[0];
                int steps = b[1];
                visited.add(nodeIndex);
                if (steps == K) {
                    res.add(map.get(nodeIndex));
                    continue;
                }

                // parent, left, right
                if (!visited.contains(nodeIndex/2) && map.containsKey(nodeIndex/2)) {
                    bfs.add(new int[]{nodeIndex/2, steps+1});
                }
                if (!visited.contains(nodeIndex*2) && map.containsKey(nodeIndex*2)) {
                    bfs.add(new int[]{nodeIndex*2, steps+1});
                }
                if (!visited.contains(nodeIndex*2+1) && map.containsKey(nodeIndex*2+1)) {
                    bfs.add(new int[]{nodeIndex*2+1, steps+1});
                }
            }

            return res;
        }

        private int buildMap(TreeNode root, int index, int target, HashMap<Integer, Integer> map) {
            int res = -1;
            map.put(index, root.val);
            if (root.val == target) {
                res = index;
            }
            if (root.left != null) {
                int t = buildMap(root.left, index*2, target, map);
                if (t != -1) {
                    res = t;
                }
            }
            if (root.right != null) {
                int t = buildMap(root.right, index*2+1, target, map);
                if (t != -1) {
                    res = t;
                }
            }
            return res;
        }
    }
}
