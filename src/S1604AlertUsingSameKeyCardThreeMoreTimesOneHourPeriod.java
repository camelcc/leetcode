import java.util.*;

public class S1604AlertUsingSameKeyCardThreeMoreTimesOneHourPeriod {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        HashSet<String> names = new HashSet<>();
        HashMap<String, TreeSet<Integer>> times = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String n = keyName[i], t = keyTime[i];
            if (names.contains(n)) {
                continue;
            }

            int time = ((t.charAt(0)-'0') * 10 + (t.charAt(1)-'0')) * 60 + (t.charAt(3)-'0') * 10 + (t.charAt(4)-'0');
            if (!times.containsKey(n)) {
                times.put(n, new TreeSet<>());
                times.get(n).add(time);
                continue;
            }

            TreeSet<Integer> all = times.get(n);
            all.add(time);
            if (all.higher(time) != null && all.higher(all.higher(time)) != null && all.higher(all.higher(time)) - time <= 60) {
                names.add(n);
                continue;
            }
            if (all.lower(time) != null && all.higher(time) != null && all.higher(time) - all.lower(time) <= 60) {
                names.add(n);
                continue;
            }
            if (all.lower(time) != null && all.lower(all.lower(time)) != null && time - all.lower(all.lower(time)) <= 60) {
                names.add(n);
                continue;
            }
            times.put(n, all);
        }
        List<String> res = new ArrayList<>(names);
        Collections.sort(res);
        return res;
    }
}
