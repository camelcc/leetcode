public class S0885SpiralMatrixIII {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int total = R*C;
        int[][] res = new int[total][2];
        res[0][0] = r0;
        res[0][1] = c0;
        int count = 1;

        int direction = 1; // east - 1, south - 2, west - 3, north - 4
        boolean rotated = false;
        int radius = 1;

        int currentLen = 0;
        int currentR = r0;
        int currentC = c0;

        while (count < total) {
            if (direction == 1) {
                currentC++;
            } else if (direction == 2) {
                currentR++;
            } else if (direction == 3) {
                currentC--;
            } else if (direction == 4) {
                currentR--;
            }
            currentLen++;
            if (currentR >= 0 && currentR < R && currentC >= 0 && currentC < C) {
                res[count][0] = currentR;
                res[count][1] = currentC;
                count++;
            }

            if (currentLen == radius) {
                if (rotated) {
                    radius++;
                    rotated = false;
                } else {
                    rotated = true;
                }
                if (direction == 4) {
                    direction = 1;
                } else {
                    direction++;
                }
                currentLen = 0;
            }
        }
        return res;
    }
}
