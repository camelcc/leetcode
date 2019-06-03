import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class S0847ShortestPathVisitingAllNodes {
    public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        int[][] dp = new int[N][1<<graph.length];
        Queue<State> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][1<<i] = 0;
            queue.offer(new State(1<<i, i));
        }

        while (!queue.isEmpty()) {
            State state = queue.poll();

            for (int next : graph[state.source]) {
                int nextMask = state.mask | 1 << next;
                if (dp[next][nextMask] > dp[state.source][state.mask]+1) {
                    dp[next][nextMask] = dp[state.source][state.mask]+1;
                    queue.offer(new State(nextMask, next));
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < graph.length; i++) {
            res = Math.min(res, dp[i][(1<<graph.length)-1]);
        }
        return res;
    }

    class State {
        public int mask, source;

        public State(int mask, int source) {
            this.mask = mask;
            this.source = source;
        }
    }
}
