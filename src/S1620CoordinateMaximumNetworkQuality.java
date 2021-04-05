import java.util.PriorityQueue;

public class S1620CoordinateMaximumNetworkQuality {
    public int[] bestCoordinate(int[][] towers, int radius) {
        double[][] power = new double[2*radius+1][2*radius+1];
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                double d = Math.sqrt(x*x+y*y);
                if (d > radius) {
                    continue;
                }
                power[x+radius][y+radius] = 1.0/(1+d);
            }
        }
        int rx = 0, ry = 0, rp = 0;
        int[][] quality = new int[51+radius][51+radius];
        for (int[] tower : towers) {
            int tx = tower[0], ty = tower[1], q = tower[2];
            for (int dx = -radius; dx <= radius; dx++) {
                for (int dy = -radius; dy <= radius; dy++) {
                    if (tx+dx < 0 || ty+dy < 0) {
                        continue;
                    }
                    int t = (int)Math.floor(power[dx+radius][dy+radius] * q);
                    quality[tx+dx][ty+dy] += t;
                    if (quality[tx+dx][ty+dy] > rp) {
                        rp = quality[tx+dx][ty+dy];
                        rx = tx+dx;
                        ry = ty+dy;
                    } else if (quality[tx+dx][ty+dy] == rp) {
                        if (tx+dx < rx || (tx+dx == rx && ty+dy < ry)) {
                            rx = tx+dx;
                            ry = ty+dy;
                        }
                    }
                }
            }
        }
        return new int[]{rx, ry};
    }
}
