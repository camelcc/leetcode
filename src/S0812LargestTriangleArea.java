public class S0812LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double area = 0;
        for (int i = 0; i < points.length-2; i++) {
            for (int j = i+1; j < points.length-1; j++) {
                for (int k = j+1; k < points.length; k++) {
                    double a = slide(points[i][0], points[i][1], points[j][0], points[j][1]);
                    double b = slide(points[j][0], points[j][1], points[k][0], points[k][1]);
                    double c = slide(points[k][0], points[k][1], points[i][0], points[i][1]);
                    double t = area(a, b, c);
                    if (t > area) {
                        area = t;
                    }
                }
            }
        }
        return area;
    }

    private double slide(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }

    private double area(double a, double b, double c) {
        double p = (a+b+c)*0.5;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
