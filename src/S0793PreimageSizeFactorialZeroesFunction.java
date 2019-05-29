public class S0793PreimageSizeFactorialZeroesFunction {
    public int preimageSizeFZF(int K) {
        return maxNum(K)-maxNum(K-1);
    }

    private int maxNum(int K) {
        long lo = 0, hi = 5L*(K+1);
        while (lo <= hi) {
            long mid = lo + (hi-lo)/2;
            long zeros = numOfZeros(mid);
            if (zeros <= K) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return (int)hi;
    }

    private long numOfZeros(long k) {
        int res = 0;
        while (k > 0) {
            res += k/5;
            k = k/5;
        }
        return res;
    }
}
