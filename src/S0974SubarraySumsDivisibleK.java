import java.util.HashMap;

public class S0974SubarraySumsDivisibleK {
    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        int sum = 0, res = 0;
        for (int i = 0; i < A.length; i++) {
            sum = (sum+A[i])%K;
            if (sum < 0) {
                sum += K;
            }
            res += cnt.getOrDefault(sum, 0);
            cnt.put(sum, cnt.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}
