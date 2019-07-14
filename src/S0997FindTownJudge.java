public class S0997FindTownJudge {
    public int findJudge(int N, int[][] trust) {
        int[] parent = new int[N+1];
        int[] children = new int[N+1];
        for (int[] t : trust) {
            parent[t[0]]++;
            children[t[1]]++;
        }

        int res = -1;
        for (int i = 1; i <= N; i++) {
            if (children[i] == N-1 && parent[i] == 0) {
                if (res == -1) {
                    res = i;
                } else {
                    return -1;
                }
            }
        }
        return res;
    }
}
