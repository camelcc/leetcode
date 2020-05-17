import java.util.HashSet;

public class S1453MaximumNumberDartsInsideCircularDartboard {
    public int numPoints(int[][] points, int r) {
        int n = points.length;
        int res = 1;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                double[] a = new double[]{points[i][0], points[i][1]};
                double[] b = new double[]{points[j][0], points[j][1]};
                double[] center = findCenter(a, b, (double)r);
                if(!Double.isNaN(center[0]) && !Double.isNaN(center[1])){
                    int cur = 2;
                    for(int k=0; k<n; k++) if(k!=i && k!=j){
                        if(dist(center, new double[]{points[k][0], points[k][1]})<=r){
                            cur++;
                        }
                    }
                    res = Math.max(res, cur);
                }
            }
        }
        return res;
    }

    public double[] findCenter(double[] a, double[] b, double r)
    {
        double[] mid = new double[2];
        double[] res = new double[2];
        mid[0]=(a[0]+b[0])/2;
        mid[1]=(a[1]+b[1])/2;
        double angle = Math.atan2(a[0]-b[0],b[1]-a[1]);
        double d = Math.sqrt(r*r-Math.pow(dist(a,mid),2));
        res[0] = mid[0]+d*Math.cos(angle);
        res[1] = mid[1]+d*Math.sin(angle);
        return res;
    }

    public double dist(double[] a, double[] b){
        return Math.sqrt(Math.pow(a[0]-b[0],2) + Math.pow(a[1]-b[1],2));
    }
}
