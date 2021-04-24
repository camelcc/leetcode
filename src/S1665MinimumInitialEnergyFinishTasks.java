import java.util.Arrays;

public class S1665MinimumInitialEnergyFinishTasks {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (int[] t1, int[] t2) -> {
            int d1 = t1[1]-t1[0];
            int d2 = t2[1]-t2[0];
            if (d1 != d2) {
                return d1-d2;
            }
            return t1[1]-t2[1];
        });
        int res = 0, sum = 0;
        for (int i = 0; i < tasks.length; i++) {
            res = Math.max(res + tasks[i][0], tasks[i][1]);
        }
        return res;
    }
}
