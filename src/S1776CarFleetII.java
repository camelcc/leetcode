import java.util.Stack;

public class S1776CarFleetII {
    public double[] getCollisionTimes(int[][] cars) {
        double[] res = new double[cars.length];
        Stack<double[]> candidates = new Stack<>();
        for (int i = cars.length-1; i >= 0; i--) {
            res[i] = -1.0;
            while (!candidates.isEmpty()) {
                int j = (int)candidates.peek()[0];
                double t = time(cars[i], cars[j]);
                if (t > 0 && (res[j] < 0 || t <= res[j])) {
                    res[i] = t;
                    break;
                }
                candidates.pop();
            }
            candidates.push(new double[]{i, res[i]});
        }
        return res;
    }

    private double time(int[] car1, int[] car2) {
        if (car1[1] <= car2[1]) {
            return -1;
        }
        return 1.0*(car2[0]-car1[0])/(car1[1]-car2[1]);
    }
}
