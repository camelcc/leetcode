import java.util.HashSet;

public class S1467ProbabilityTwoBoxesHavingTheSameNumberDistinctBalls {
    public double getProbability(int[] balls) {
        long total = total(balls, 0, 0, 0, 0, 0);
        long match = match(balls, 0, 0, 0, 0, 0);
        return (1.0*match)/total;
    }

    private long total(int[] balls, int pa, int pb, int ca, int cb, int p) {
        if (p == balls.length) {
            return pa == pb ? 1 : 0;
        }
        long res = 0;
        for (int i = 0; i <= balls[p]; i++) {
            res += total(balls, pa+i, pb+balls[p]-i, i == 0 ? ca : ca+1, i == balls[p] ? cb : cb+1, p+1) * CNA(balls[p], i);
        }
        return res;
    }

    private long match(int[] balls, int pa, int pb, int ca, int cb, int p) {
        if (p == balls.length) {
            return (pa == pb && ca == cb) ? 1 : 0;
        }
        long res = 0;
        for (int i = 0; i <= balls[p]; i++) {
            res += match(balls, pa+i, pb+balls[p]-i, i == 0 ? ca : ca+1, i == balls[p] ? cb : cb+1, p+1) * CNA(balls[p], i);
        }
        return res;
    }

    // pick a from n, how many unique ways
    private long CNA(int n, int a) {
        return A(n)/(A(a)*A(n-a));
    }

    private long A(long c) {
        long total = 1;
        while (c > 0) {
            total = total * c;
            c--;
        }
        return total;
    }
}
