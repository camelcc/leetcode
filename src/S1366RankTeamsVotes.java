import java.util.HashMap;
import java.util.PriorityQueue;

public class S1366RankTeamsVotes {
    public String rankTeams(String[] votes) {
        if (votes.length == 1) {
            return votes[0];
        }
        int N = votes[0].length();
        HashMap<Character, int[]> cnt = new HashMap<>();
        for (String v : votes) {
            for (int i = 0; i < v.length(); i++) {
                char t = v.charAt(i);
                cnt.putIfAbsent(t, new int[N]);
                cnt.get(t)[i]++;
            }
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((t1, t2) -> {
            int[] v1 = cnt.get(t1);
            int[] v2 = cnt.get(t2);
            for (int i = 0; i < N; i++) {
                if (v1[i] != v2[i]) {
                    return v2[i]-v1[i];
                }
            }
            return t1-t2;
        });
        for (Character c : cnt.keySet()) {
            pq.offer(c);
        }
        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()) {
            res.append(pq.poll());
        }
        return res.toString();
    }
}
