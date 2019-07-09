import java.util.*;

public class S0967NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> res = new ArrayList<>();
        Queue<List<Integer>> bfs = new LinkedList<>();
        for (int i = (N == 1 ? 0 : 1); i < 10; i++) {
            List<Integer> t = new ArrayList<>();
            t.add(i);
            bfs.offer(t);
        }

        while (!bfs.isEmpty()) {
            List<Integer> t = bfs.poll();
            if (t.size() == N) {
                int num = 0;
                for (int d : t) {
                    num = num*10 + d;
                }
                res.add(num);
            } else {
                int last = t.get(t.size()-1);
                if (last + K < 10) {
                    List<Integer> next = new ArrayList<>(t);
                    next.add(last+K);
                    bfs.offer(next);
                }
                if (K != 0 && last - K >= 0) {
                    List<Integer> next = new ArrayList<>(t);
                    next.add(last-K);
                    bfs.offer(next);
                }
            }
        }

        int[] r = new int[res.size()];
        int i = 0;
        for (int v : res) {
            r[i++] = v;
        }
        return r;
    }
}
