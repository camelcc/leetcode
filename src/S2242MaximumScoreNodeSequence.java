public class S2242MaximumScoreNodeSequence {
    public int maximumScore(int[] scores, int[][] edges) {
        int N = scores.length;
        int[][][] graph = new int[N][3][2];
        for (int i = 0; i < N; i++) {
            graph[i] = new int[][]{{-1, -1}, {-1, -1}, {-1, -1}};
        }
        for (int[] edge : edges) {
            int n1 = edge[0], s1 = scores[n1], n2 = edge[1], s2 = scores[n2];
            add(graph, n1, s1, n2, s2);
            add(graph, n2, s2, n1, s1);
        }
        int res = -1;
        for (int[] edge : edges) {
            int n1 = edge[0], n2 = edge[1];
            int r1 = pick(scores, graph, n1, n2);
            res = Math.max(res, r1);
            int r2 = pick(scores, graph, n2, n1);
            res = Math.max(res, r2);
        }
        return res;
    }

    private int pick(int[] scores, int[][][] graph, int n1, int n2) {
        int c1 = -1;
        if (graph[n1][0][1] > 0 && graph[n1][0][0] != n2) {
            c1 = graph[n1][0][0];
        } else if (graph[n1][1][1] > 0 && graph[n1][1][0] != n2) {
            c1 = graph[n1][1][0];
        } else if (graph[n1][2][1] > 0 && graph[n1][2][0] != n2) {
            c1 = graph[n1][2][0];
        }
        if (c1 == -1) {
            return -1;
        }
        int c2 = -1;
        if (graph[n2][0][1] > 0 && graph[n2][0][0] != n1 && graph[n2][0][0] != c1) {
            c2 = graph[n2][0][0];
        } else if (graph[n2][1][1] > 0 && graph[n2][1][0] != n1 && graph[n2][1][0] != c1) {
            c2 = graph[n2][1][0];
        } else if (graph[n2][2][1] > 0 && graph[n2][2][0] != n1 && graph[n2][2][0] != c1) {
            c2 = graph[n2][2][0];
        }
        if (c2 == -1) {
            return -1;
        }
        return scores[c1] + scores[n1] + scores[n2] + scores[c2];
    }

    private void add(int[][][] graph, int n1, int s1, int n2, int s2) {
        // add n1 to n2
        if (s1 >= graph[n2][0][1]) {
            if (n1 != graph[n2][0][0]) {
                graph[n2][2][0] = graph[n2][1][0];
                graph[n2][2][1] = graph[n2][1][1];
                graph[n2][1][0] = graph[n2][0][0];
                graph[n2][1][1] = graph[n2][0][1];
                graph[n2][0][0] = n1;
                graph[n2][0][1] = s1;
            }
        } else { // s1 < graph[n2][0][1]
            if (s1 >= graph[n2][1][1]) {
                if (n1 != graph[n2][1][0]) {
                    graph[n2][2][0] = graph[n2][1][0];
                    graph[n2][2][1] = graph[n2][1][1];
                    graph[n2][1][0] = n1;
                    graph[n2][1][1] = s1;
                }
            } else { // s1 < graph[n2][1][1]
                if (s1 >= graph[n2][2][1]) {
                    if (n1 != graph[n2][2][0]) {
                        graph[n2][2][0] = n1;
                        graph[n2][2][1] = s1;
                    }
                }
            }
        }
    }
}
