import java.util.Random;

public class S0478GenerateRandomPointCircle {
    class Solution {
        private double r;
        private double x, y;

        public Solution(double radius, double x_center, double y_center) {
            r = radius;
            x = x_center;
            y = y_center;
        }

        public double[] randPoint() {
            double angle = 2 * Math.PI * Math.random();
            double radius = r * Math.sqrt(Math.random());
            double rx = x + Math.cos(angle)*radius;
            double ry = y + Math.sin(angle)*radius;
            return new double[]{rx, ry};
        }
    }
}
