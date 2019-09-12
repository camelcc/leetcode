public class S1184DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) {
            return 0;
        }
        if (start > destination) {
            int t = start;
            start = destination;
            destination = t;
        }

        int total = 0;
        int positive = 0;
        for (int i = 0; i < distance.length; i++) {
            total += distance[i];
            if (i >= start && i < destination) {
                positive += distance[i];
            }
        }
        return Math.min(total-positive, positive);
    }
}
