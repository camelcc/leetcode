import java.util.HashMap;

public class S1386CinemaSeatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, boolean[]> map = new HashMap<>();
        for (int[] r : reservedSeats) {
            map.putIfAbsent(r[0], new boolean[6]);
            map.get(r[0])[r[1]/2] = true;
        }

        int res = 2*(n-map.size());
        for (int r : map.keySet()) {
            boolean[] reserved = map.get(r);
            if (!reserved[1] && !reserved[2] && !reserved[3] && !reserved[4]) {
                res += 2;
            } else if (!reserved[1] && !reserved[2]) {
                res++;
            } else if (!reserved[3] && !reserved[4]) {
                res++;
            } else if (!reserved[2] && !reserved[3]) {
                res++;
            }
        }
        return res;
    }
}
