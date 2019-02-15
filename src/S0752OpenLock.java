import java.util.*;

public class S0752OpenLock {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }
        int targ = Integer.valueOf(target);
        int[] visited = new int[10000];
        Arrays.fill(visited, -1);
        for (String d : deadends) {
            visited[Integer.valueOf(d)] = Integer.MAX_VALUE;
        }
        if (visited[0] != -1) {
            return -1;
        }
        visited[0] = 0;

        List<Integer> pool = new ArrayList<>();
        pool.add(0);
        while (!pool.isEmpty()) {
            int t = pool.remove(0);
            int steps = visited[t];
            if (t == targ) {
                return steps;
            }

            int[] p = new int[4];
            p[0] = t/1000;
            p[1] = (t/100)%10;
            p[2] = (t/10)%10;
            p[3] = t%10;

            int p1up = 1000*((p[0]+1)%10)+100*p[1]+10*p[2]+p[3];
            if (visited[p1up] == -1) {
                visited[p1up] = steps+1;
                pool.add(p1up);
            }
            int p1down = 1000*((10+p[0]-1)%10)+100*p[1]+10*p[2]+p[3];
            if (visited[p1down] == -1) {
                visited[p1down] = steps+1;
                pool.add(p1down);
            }
            int p2up = 1000*p[0]+100*((p[1]+1)%10)+10*p[2]+p[3];
            if (visited[p2up] == -1) {
                visited[p2up] = steps+1;
                pool.add(p2up);
            }
            int p2down = 1000*p[0]+100*((p[1]+10-1)%10)+10*p[2]+p[3];
            if (visited[p2down] == -1) {
                visited[p2down] = steps+1;
                pool.add(p2down);
            }
            int p3up = 1000*p[0]+100*p[1]+10*((p[2]+1)%10)+p[3];
            if (visited[p3up] == -1) {
                visited[p3up] = steps+1;
                pool.add(p3up);
            }
            int p3down = 1000*p[0]+100*p[1]+10*((p[2]+10-1)%10)+p[3];
            if (visited[p3down] == -1) {
                visited[p3down] = steps+1;
                pool.add(p3down);
            }
            int p4up = 1000*p[0]+100*p[1]+10*p[2]+((p[3]+1)%10);
            if (visited[p4up] == -1) {
                visited[p4up] = steps+1;
                pool.add(p4up);
            }
            int p4down = 1000*p[0]+100*p[1]+10*p[2]+((10+p[3]-1)%10);
            if (visited[p4down] == -1) {
                visited[p4down] = steps+1;
                pool.add(p4down);
            }
        }

        return -1;
    }
}
