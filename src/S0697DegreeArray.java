import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0697DegreeArray {
    public int findShortestSubArray(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        HashMap<Integer, Integer> cnt = new HashMap<>();
        HashMap<Integer, Integer> min = new HashMap<>();
        HashMap<Integer, Integer> max = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            cnt.put(n, cnt.getOrDefault(n, 0)+1);
            min.put(n, min.getOrDefault(n, i));
            max.put(n, i);
        }

        int highest = 0;
        List<Integer> most = new ArrayList<>();
        for (int n : cnt.keySet()) {
            int f = cnt.get(n);
            if (f > highest) {
                highest = cnt.get(n);
                most.clear();
                most.add(n);
            } else if (f == highest) {
                most.add(n);
            }
        }

        int shortest = Integer.MAX_VALUE;
        for (int m : most) {
            int len = (max.get(m) - min.get(m) + 1);
            if (len < shortest) {
                shortest = len;
            }
        }
        return shortest;
    }
}
