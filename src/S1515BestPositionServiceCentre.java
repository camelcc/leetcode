public class S1515BestPositionServiceCentre {
    private static final double PRECISION = 1e-6;

    public double getMinDistSum(int[][] positions) {
        return solve(positions);
    }

    private double solve(int[][] positions) {
        double xl = 0, xr = 1e2;

        while (xr - xl >= PRECISION) {
            double tl = (xl + xl + xr) / 3.0;
            double tr = (xl + xr + xr) / 3.0;

            double sl = solve(positions, tl);
            double sr = solve(positions, tr);

            if (sl <= sr) {
                xr = tr;
            } else {
                xl = tl;
            }
        }

        return solve(positions, xl);
    }

    private double solve(int[][] positions, double x) {
        double yl = 0, yr = 1e2;

        while (yr - yl >= PRECISION) {
            double tl = (yl + yl + yr) / 3.0;
            double tr = (yl + yr + yr) / 3.0;

            double sl = calculate(positions, x, tl);
            double sr = calculate(positions, x, tr);

            if (sl <= sr) {
                yr = tr;
            } else {
                yl = tl;
            }
        }

        return calculate(positions, x, yl);
    }

    private double calculate(int[][] positions, double x, double y) {
        double answer = 0;

        for (int[] pos : positions) {
            answer += Math.sqrt(Math.pow(pos[0] - x, 2) + Math.pow(pos[1] - y, 2));
        }

        return answer;
    }
}
