public class S0396RotateFunction {
    public int maxRotateFunction(int[] A) {
        if (A.length <= 1) {
            return 0;
        }

        int sum = 0;
        for (int n : A) {
            sum += n;
        }

        double[] diff = new double[A.length];
        diff[0] = 0;
        for (int i = 1; i < A.length; i++) {
            diff[i] = sum - A.length * A[A.length - i];
        }

        sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += i * A[i];
        }

        int max = sum;
        for (int i = 1; i < diff.length; i++) {
            sum += diff[i];
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }
}
