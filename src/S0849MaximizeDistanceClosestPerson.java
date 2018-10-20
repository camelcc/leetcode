public class S0849MaximizeDistanceClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int dis = 0;
        int pre = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (pre < 0) {
                    if (i > dis) {
                        dis = i;
                    }
                } else {
                    if ((i - pre) / 2 > dis) {
                        dis = (i - pre) / 2;
                    }
                }

                pre = i;
            }
        }
        if ((seats.length-1-pre) > dis) {
            dis = seats.length-1-pre;
        }
        return dis;
    }
}
