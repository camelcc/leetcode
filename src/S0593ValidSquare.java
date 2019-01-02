public class S0593ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int t1 = squareDistance(p1, p2);
        int t2 = squareDistance(p1, p3);
        if (t1 == 0 || t2 == 0) {
            return false;
        }
        if (t1 == t2) {
            int longer = squareDistance(p1, p4);
            return (t1+t2==longer) && (squareDistance(p2, p4) == t1) && (squareDistance(p3, p4) == t1);
        } else {
            if (t1 > t2) {
                return (squareDistance(p1, p4) == t2) && (t2+t2==t1) && (squareDistance(p2, p3) == t2) && (squareDistance(p2, p4) == t2);
            } else {
                return (squareDistance(p1, p4) == t1) && (t1+t1==t2) && (squareDistance(p2, p3) == t1) && (squareDistance(p3, p4) == t1);
            }
        }
    }

    private int squareDistance(int[] p1, int[] p2) {
        return (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]);
    }
}
