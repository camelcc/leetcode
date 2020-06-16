import java.util.HashMap;

public class S1477FindTwoNonoverlappingSubarraysEachWithTargetSum {
    public int minSumOfLengths(int[] arr, int target) {
        int res = -1;

        int[] len = new int[arr.length];

        HashMap<Integer, Integer> sum = new HashMap<>();
        sum.put(0, -1);
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
            sum.put(s, i);
            if (sum.containsKey(s-target)) {
                int prev = sum.get(s-target);
                int l = i-prev;
                if (prev == -1) {
                    len[i] = l;
                    continue;
                }

                if (len[prev] > 0) {
                    if (res == -1) {
                        res = len[prev] + l;
                    } else {
                        res = Math.min(res, len[prev] + l);
                    }
                }
                len[i] = l;
                if (i > 0) {
                    len[i] = Math.min(len[i], len[i-1]);
                }
            } else {
                if (i > 0) {
                    len[i] = len[i-1];
                }
            }
        }
        return res;
    }
}
