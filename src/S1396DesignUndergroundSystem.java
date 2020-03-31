import java.util.HashMap;

public class S1396DesignUndergroundSystem {
    class UndergroundSystem {
        private HashMap<String, double[]> time;
        private HashMap<Integer, String[]> checkin;

        public UndergroundSystem() {
            time = new HashMap<>();
            checkin = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            if (checkin.containsKey(id)) {
                return;
            }
            checkin.put(id, new String[]{stationName, String.valueOf(t)});
        }

        public void checkOut(int id, String stationName, int t) {
            if (!checkin.containsKey(id)) {
                return;
            }
            String[] in = checkin.remove(id);
            String travel = in[0]+" "+stationName;
            int current = t-Integer.parseInt(in[1]);
            if (!time.containsKey(travel)) {
                time.put(travel, new double[]{current, 1});
            } else {
                double[] before = time.get(travel);
                double total = (before[0]*before[1] + current);
                time.put(travel, new double[]{total/(before[1]+1), before[1]+1});
            }
        }

        public double getAverageTime(String startStation, String endStation) {
            String travel = startStation + " " + endStation;
            if (!time.containsKey(travel)) {
                return 0;
            } else {
                return time.get(travel)[0];
            }
        }
    }
}
