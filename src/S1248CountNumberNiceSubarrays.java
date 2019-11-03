import java.util.HashMap;

public class S1248CountNumberNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> preFreq = new HashMap<>();
        int cnt = 0, f = 0, i = 0;
        while (i < nums.length) {
            f++;
            if (nums[i]%2 == 1) {
                cnt++;
                preFreq.put(cnt, f);
                f = 0;
            }

            i++;
        }
        HashMap<Integer, Integer> postFreq = new HashMap<>();
        cnt = 0;
        f = 0;
        i = 0;
        while (i < nums.length) {
            if (nums[i]%2 == 1) {
                cnt++;
                f = 1;
            } else {
                f++;
            }

            postFreq.put(cnt, f);
            i++;
        }

        int res = 0;
        for (int c = k; c <= cnt; c++) {
            res += postFreq.getOrDefault(c, 0)*preFreq.getOrDefault(c-k+1, 0);
        }
        return res;
    }
}
