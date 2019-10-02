import java.util.*;

public class S1210MinimumMovesReachTargetRotations {
    public int minimumMoves(int[][] grid) {
        int N = grid.length;
        HashSet<String> visited = new HashSet<>();
        Queue<int[][]> bfs = new LinkedList<>();
        bfs.offer(new int[][]{new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 0}});
        while (!bfs.isEmpty()) {
            int[][] t = bfs.poll();
            int[] s1 = t[0], s2 = t[1];
            int steps = t[2][0];
            String p = String.format("[%d][%d],[%d][%d]", s1[0], s1[1], s2[0], s2[1]);
            if (visited.contains(p)) {
                continue;
            }
            visited.add(p);

            if (s1[0] == N-1 && s1[1] == N-2 && s2[0] == N-1 && s2[1] == N-1) {
                return steps;
            }
            List<int[][]> next = new ArrayList<>();
            // right
            next.add(new int[][]{
                    new int[] {s1[0], s1[1]+1},
                    new int[] {s2[0], s2[1]+1},
                    new int[] {steps+1, steps+1}
            });
            // down
            next.add(new int[][] {
                    new int[] {s1[0]+1, s1[1]},
                    new int[] {s2[0]+1, s2[1]},
                    new int[] {steps+1, steps+1}
            });
            // clock
            if (s1[0] == s2[0] && s1[0] < N-1 && grid[s1[0]+1][s1[1]] == 0 && grid[s2[0]+1][s2[1]] == 0) {
                next.add(new int[][] {
                        new int[] {s1[0], s1[1]},
                        new int[] {s2[0]+1, s2[1]-1},
                        new int[] {steps+1, steps+1}
                });
            }
            // counter
            if (s1[1] == s2[1] && s1[1] < N-1 && grid[s1[0]][s1[1]+1] == 0 && grid[s2[0]][s2[1]+1] == 0) {
                next.add(new int[][] {
                        new int[] {s1[0], s1[1]},
                        new int[] {s2[0]-1, s2[1]+1},
                        new int[] {steps+1, steps+1}
                });
            }
            for (int[][] n : next) {
                int[] ns1 = n[0], ns2 = n[1];
                if (ns1[0] < 0 || ns1[0] >= N || ns1[1] < 0 || ns1[1] >= N || grid[ns1[0]][ns1[1]] == 1 ||
                    ns2[0] < 0 || ns2[0] >= N || ns2[1] < 0 || ns2[1] >= N || grid[ns2[0]][ns2[1]] == 1) {
                    continue;
                }
                String ns = String.format("[%d][%d],[%d][%d]", ns1[0], ns1[1], ns2[0], ns2[1]);
                if (visited.contains(ns)) {
                    continue;
                }

                bfs.offer(n);
            }
        }
        return -1;
    }
}
