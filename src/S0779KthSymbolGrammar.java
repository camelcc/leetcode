public class S0779KthSymbolGrammar {
    public int kthGrammar(int N, int K) {
        if (N == 1 && K == 1) {
            return 0;
        }

        int v = kthGrammar(N-1, (K+1)/2);
        if (v == 0) {
            v = 1;
        } else {
            v = 2;
        }
        int p = (K+1)%2;
        if (p == 0) {
            return v/2;
        } else {
            return v%2;
        }
    }
}
