import java.util.HashMap;

public class S0992SubarraysKDifferentIntegers {
    public int subarraysWithKDistinct(int[] A, int K) {
        int res = 0, start = 0, end = -1;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        while (start < A.length) {
            while (end+1 < A.length && cnt.size() < K) {
                end++;
                cnt.put(A[end], cnt.getOrDefault(A[end], 0) + 1);
            }
            if (cnt.size() < K) {
                break;
            }
            assert cnt.size() == K;
            int j = end;
            while (j < A.length && cnt.containsKey(A[j])) {
                res++;
                j++;
            }
            cnt.put(A[start], cnt.get(A[start])-1);
            if (cnt.get(A[start]) == 0) {
                cnt.remove(A[start]);
            }
            start++;
        }
        return res;
    }
}
