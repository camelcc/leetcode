import java.util.*;

public class S0565ArrayNesting {
    public int arrayNesting(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] group = new int[nums.length];
        Arrays.fill(group, -1);

        int gi = 0;
        int gn = 0;
        while (gi < nums.length) {
            if (group[gi] != -1) {
                gi++;
                continue;
            }

            group[gi] = gn;
            List<Integer> queue = new ArrayList<>();
            queue.add(gi);
            while (!queue.isEmpty()) {
                int p = queue.remove(0);
                int next = nums[p];
                if (group[next] == -1) {
                    group[next] = gn;
                    queue.add(next);
                }
            }

            gn++;
            gi++;
        }

        // count
        HashMap<Integer, Integer> gr = new HashMap<>();
        for (int i = 0; i < group.length; i++) {
            gr.put(group[i], gr.getOrDefault(group[i], 0)+1);
        }
        int max = 0;
        for (int v : gr.values()) {
            if (max < v) {
                max = v;
            }
        }
        return max;
    }
}
