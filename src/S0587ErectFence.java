import java.util.Arrays;
import java.util.Stack;

public class S0587ErectFence {
    public int[][] outerTrees(int[][] points) {
        if (points.length <= 2) {
            return points;
        }

        int[] current = points[0];
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[1] < current[1]) {
                current = point;
            } else if (point[1] == current[1]) {
                if (point[0] < current[0]) {
                    current = point;
                }
            }
        }

        sortByPolar(points, current);
        Stack<int[]> stack = new Stack<>();
        stack.push(points[0]);
        stack.push(points[1]);
        for (int i = 2; i < points.length; i++) {
            int[] top = stack.pop();
            while (ccw(stack.peek(), top, points[i]) < 0) {
                top = stack.pop();
            }
            stack.push(top);
            stack.push(points[i]);
        }
        return stack.toArray(new int[0][0]);
    }

    private static int ccw(int[] a, int[] b, int[] c) {
        return a[1]*b[0]-a[0]*b[1]+b[1]*c[0]-b[0]*c[1]+c[1]*a[0]-c[0]*a[1];
//        return a.x * b.y - a.y * b.x + b.x * c.y - b.y * c.x + c.x * a.y - c.y * a.x;
    }

//    private int ccw(int[] A, int[] B, int[] C) {
//        // Get the vectors' coordinates.
//        int BAx = A[1]-B[1];
//        int BAy = A[0]-B[0];
//        int BCx = C[1]-B[1];
//        int BCy = C[0]-B[0];
//        // Calculate the Z coordinate of the cross product.
//        return -(BAx * BCy - BAy * BCx);
//    }

    private int dist(int[] p1, int[] p2) {
        return (p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
    }

    private void sortByPolar(int[][] points, int[] r) {
        Arrays.sort(points, (p, q) -> {
            int compPolar = ccw(p, r, q);
            int compDist = dist(p, r) - dist(q, r);
            return compPolar == 0 ? compDist : compPolar;
        });
        // find collinear points in the end positions
        int[] p = points[0], q = points[points.length - 1];
        int i = points.length - 2;
        while (i >= 0 && ccw(p, q, points[i]) == 0)
            i--;
        // reverse sort order of collinear points in the end positions
        for (int l = i + 1, h = points.length - 1; l < h; l++, h--) {
            int[] tmp = points[l];
            points[l] = points[h];
            points[h] = tmp;
        }
    }
}
