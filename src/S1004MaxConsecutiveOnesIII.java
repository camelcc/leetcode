public class S1004MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int left = 0, res = 0, current = 0;
        for (int right = 0; right < A.length; right++) {
            if (A[right] == 0) {
                res = Math.max(res, right-left);
                if (current < K) {
                    current++;
                } else { // current == K
                    while (A[left] == 1) {
                        left++;
                    }
                    res = Math.max(res, right-left);
                    left++;
                }
            }
        }
        res = Math.max(res, A.length-left);
        return res;
    }
}
