import java.util.Arrays;

public class S0923_3SumWithMultiplicity {
    public int threeSumMulti(int[] A, int target) {
        int MOD = (int)(Math.pow(10, 9))+7;
        Arrays.sort(A);
        long res = 0;
        for (int first = 0; first < A.length-2; first++) {
            if (A[first] > target) {
                continue;
            }
            int remains = target-A[first];

            int lo = first+1, hi = A.length-1;
            while (lo < hi) {
                int sum = A[lo]+A[hi];
                if (sum < remains) {
                    lo++;
                } else if (sum == remains) {
                    if (A[lo] == A[hi]) {
                        res = (res + (hi-lo+1)*(hi-lo)/2)%MOD;
                        break;
                    }

                    int l = lo+1;
                    while (A[l] == A[lo]) {
                        l++;
                    }
                    assert l <= hi;
                    int r = hi-1;
                    while (A[r] == A[hi]) {
                        r--;
                    }
                    assert r >= lo;
                    res = (res + (l-lo)*(hi-r))%MOD;
                    lo = l;
                    hi = r;
                } else { // sum > r
                    hi--;
                }
            }
        }
        return (int)res;
    }
}
