import java.util.HashSet;
import java.util.TreeMap;

public class S2251NumberFlowersFullBloom {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        TreeMap<Integer, HashSet<Integer>> pt = new TreeMap<>();
        for (int i = 0; i < persons.length; i++) {
            pt.putIfAbsent(persons[i], new HashSet<>());
            pt.get(persons[i]).add(i);
        }

        TreeMap<Integer, Integer> bloom = new TreeMap<>();
        for (int i = 0; i < flowers.length; i++) {
            int start = flowers[i][0], end = flowers[i][1];
            bloom.put(start, bloom.getOrDefault(start, 0)+1);
            bloom.put(end+1, bloom.getOrDefault(end+1, 0)-1);
        }

        int[] res = new int[persons.length];

        int cnt = 0;
        for (int day : bloom.keySet()) {
            // current bloom cnt flowers
            while (!pt.isEmpty() && pt.firstKey() < day) {
                HashSet<Integer> ps = pt.remove(pt.firstKey());
                for (int index : ps) {
                    res[index] = cnt;
                }
            }

            cnt += bloom.get(day);
        }

        return res;
    }
}
