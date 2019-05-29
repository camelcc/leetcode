public class S0798SmallestRotationHighestScore {
    public int bestRotation(int[] A) {
        int N = A.length;
        int[] change = new int[N];
        for (int i = 0; i < N; i++) {
            change[(i-A[i]+1+N)%N] -= 1;
        }
        int res = 0;
        for (int i = 1; i < N; i++) {
            change[i] += change[i-1]+1;
            res = change[i] > change[res] ? i : res;
        }
        return res;
    }
}
