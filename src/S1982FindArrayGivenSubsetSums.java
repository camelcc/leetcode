import java.util.Arrays;

// https://leetcode.com/problems/find-array-given-subset-sums/discuss/1421426/Java-Short-and-Clean-Solution-O(N*2N)-with-explanation-(41-ms-beats-100)
public class S1982FindArrayGivenSubsetSums {
    public int[] recoverArray(int n, int[] sums) {
        Arrays.sort(sums);
        int m = sums.length, zeroShift = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            int diff = sums[1] - sums[0], hasZero = 0, p = 0, k = 0, zpos = m;
            for (int j = 0; j < m; ++j) {
                if (k < p && sums[k] == sums[j]) k++;
                else {
                    if (zeroShift == sums[j]) zpos = p;
                    sums[p++] = sums[j] + diff;
                }
            }
            if (zpos >= m / 2) {
                res[i] = -diff;
            } else {
                res[i] = diff;
                zeroShift += diff;
            }
            m /= 2;
        }
        return res;
    }
}
