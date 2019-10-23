import java.util.Arrays;

public class S1227AirplaneSeatAssignmentProbability {
    public double nthPersonGetsNthSeat(int n) {
        if (n == 1) {
            return 1.0;
        }

        double occupied = 1.0/n;
        for (int i = 1; i < n-1; i++) {
            double o = occupied / (n-i);
            occupied += o;
        }
        return 1.0 - occupied;
    }
}
