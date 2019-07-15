public class S1006ClumsyFactorial {
    public int clumsy(int N) {
        if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N == 3) {
            return 6;
        }
        int res = N*(N-1)/(N-2)+N-3;
        N -= 4;
        while (N >= 4) {
            res -= (N*(N-1)/(N-2)-(N-3));
            N -= 4;
        }
        if (N == 3) {
            res -= 6;
        } else if (N == 2) {
            res -= 2;
        } else if (N == 1) {
            res -= 1;
        }
        return res;
    }
}
