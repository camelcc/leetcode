import java.util.ArrayList;
import java.util.List;

public class S0659SplitArrayConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        List<int[]> sequences = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            boolean added = false;
            int pos = 0;

            for (int p = 0; p < sequences.size(); p++) {
                if (sequences.get(p)[0]+1 == n) {
                    if (!added) {
                        pos = p;
                        added = true;
                    } else {
                        if (sequences.get(pos)[1] > sequences.get(p)[1]) {
                            pos = p;
                        }
                    }
                }
            }
            if (!added) {
                sequences.add(new int[]{n, 1});
            } else {
                int[] t = sequences.get(pos);
                t[0] = n;
                t[1]++;
            }
        }

        for (int[] seq : sequences) {
            if (seq[1] < 3) {
                return false;
            }
        }
        return true;
    }
}
