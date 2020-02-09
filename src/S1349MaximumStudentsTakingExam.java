import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class S1349MaximumStudentsTakingExam {
    public int maxStudents(char[][] seats) {
        int M = seats.length, N = seats[0].length;
        HashMap<String, Integer>[] dp = new HashMap[M];
        for (int i = 0; i < M; i++) {
            dp[i] = new HashMap<>();
        }
        char[] p = new char[N];
        Arrays.fill(p, '#');

        return max(seats, new String(p), 0, dp);
    }

    private int max(char[][] seats, String prev, int current, HashMap<String, Integer>[] dp) {
        int M = seats.length, N = seats[0].length;
        if (current >= M) {
            return 0;
        }
        if (dp[current].containsKey(prev)) {
            return dp[current].get(prev);
        }

        int res = 0;
        for (String cur : comb(seats[current], prev, 0)) {
            int cnt = 0;
            for (char c : cur.toCharArray()) {
                if (c == 's') {
                    cnt++;
                }
            }
            cnt += max(seats, cur, current+1, dp);
            res = Math.max(res, cnt);
        }
        dp[current].put(prev, res);
        return res;
    }

    private List<String> comb(char[] seats, String p, int c) {
        List<String> res = new ArrayList<>();
        if (c >= seats.length) {
            res.add(new String(seats));
            return res;
        }
        res.addAll(comb(seats, p, c+1));

        char[] prev = p.toCharArray();
        if (seats[c] != '.' ||
                (c > 0 && seats[c-1] == 's') ||
                (c > 0 && prev[c-1] == 's') ||
                (c < seats.length-1 && seats[c+1] == 's') ||
                (c < seats.length-1 && prev[c+1] == 's')) {
            return res;
        }
        char[] next = Arrays.copyOf(seats, seats.length);
        next[c] = 's';
        res.addAll(comb(next, p, c+1));
        return res;
    }
}
