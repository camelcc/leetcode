import java.util.Arrays;
import java.util.Comparator;

public class S0853CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        Integer[] indexs = new Integer[position.length];
        for (int i = 0; i < position.length; i++) {
            indexs[i] = i;
        }
        Arrays.sort(indexs, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return position[o2] - position[o1];
            }
        });

        double time = -1;
        int cnt = 0;
        for (int i = 0; i < indexs.length; i++) {
            int index = indexs[i];
            double t = ((double)(target-position[index]))/speed[index];
            if (t > time) {
                cnt++;
                time = t;
            }
        }

        return cnt;
    }
}
