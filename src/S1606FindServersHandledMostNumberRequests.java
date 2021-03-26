import java.util.*;

public class S1606FindServersHandledMostNumberRequests {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        HashSet<Integer> res = new HashSet<>();
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int max = 0;

        TreeMap<Integer, TreeSet<Integer>> schedule = new TreeMap<>();
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {
            int start = arrival[i], end = start+load[i];
            Integer t = schedule.floorKey(start);
            while (t != null) {
                available.addAll(schedule.remove(t));
                t = schedule.lowerKey(t);
            }
            if (available.isEmpty()) {
                continue;
            }
            Integer n = available.ceiling(i%k);
            if (n == null) {
                n = available.first();
            }
            available.remove(n);
            schedule.putIfAbsent(end, new TreeSet<>());
            schedule.get(end).add(n);
            cnt.put(n, cnt.getOrDefault(n, 0)+1);
            if (cnt.get(n) > max) {
                res = new HashSet<>();
                res.add(n);
                max = cnt.get(n);
            } else if (cnt.get(n) == max) {
                res.add(n);
            }

        }
        return new ArrayList<>(res);
    }
}
