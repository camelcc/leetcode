import java.util.Arrays;

public class S1817FindingUsersActiveMinutes {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Arrays.sort(logs, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1]-o2[1];
            }
            return o1[0]-o2[0];
        });
        int[] res = new int[k];
        int user = -1, cnt = 0, time = 0;
        for (int i = 0; i < logs.length; i++) {
            int u = logs[i][0], t = logs[i][1];
            if (u != user) {
                if (cnt > 0) {
                    res[cnt-1]++;
                }
                user = u;
                cnt = 1;
                time = t;
            } else {
                if (t == time) {
                    continue;
                } else {
                    cnt++;
                    time = t;
                }
            }
        }
        if (cnt > 0) {
            res[cnt-1]++;
        }
        return res;
    }
}
