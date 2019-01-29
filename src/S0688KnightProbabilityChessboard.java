import java.util.Arrays;

public class S0688KnightProbabilityChessboard {
    double[][][] krc;

    public double knightProbability(int N, int K, int r, int c) {
        if (K == 0) {
            return (r<N && c<N) ? 1 : 0;
        }

        krc = new double[K][N][N];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(krc[i][j], -1);
            }
        }
        return pro(N, K, r, c);
    }

    private double pro(int N, int K, int r, int c) {
        assert K >= 1;
        if (krc[K-1][r][c] != -1) {
            return krc[K-1][r][c];
        }

        double p = 0.0;

        if (r-1>=0 && c-2 >= 0) {
            p += (1.0/8) * (K == 1 ? 1 : pro(N, K-1, r-1, c-2));
        }
        if (r-2>=0 && c-1>=0) {
            p += (1.0/8) * (K == 1 ? 1 : pro(N, K-1, r-2, c-1));
        }
        if (r-2>=0 && c+1<N) {
            p += (1.0/8) * (K == 1 ? 1 : pro(N, K-1, r-2, c+1));
        }
        if (r-1>=0 && c+2<N) {
            p += (1.0/8) * (K == 1 ? 1 : pro(N, K-1, r-1, c+2));
        }
        if (r+1<N && c+2<N) {
            p += (1.0/8) * (K == 1 ? 1 : pro(N, K-1, r+1, c+2));
        }
        if (r+2<N && c+1<N) {
            p += (1.0/8) * (K == 1 ? 1 : pro(N, K-1, r+2, c+1));
        }
        if (r+2<N && c-1>=0) {
            p += (1.0/8) * (K == 1 ? 1 : pro(N, K-1, r+2, c-1));
        }
        if (r+1<N && c-2>=0) {
            p += (1.0/8) * (K == 1 ? 1 : pro(N, K-1, r+1, c-2));
        }
        krc[K-1][r][c] = p;
        return p;
    }
}
