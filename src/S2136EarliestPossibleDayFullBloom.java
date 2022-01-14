import java.util.Arrays;

public class S2136EarliestPossibleDayFullBloom {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int N = plantTime.length;
        Integer[] indices = new Integer[N];
        for (int i = 0; i < N; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (o1, o2) -> growTime[o2]-growTime[o1]);
        int res = 0, plant = 0;
        for (int i = 0; i < N; i++) {
            int j = indices[i];
            // plant j
            int bloom = plant+plantTime[j]+growTime[j];
            if (bloom > res) {
                res = bloom;
            }
            plant = plant+plantTime[j];
        }
        return res;
    }
}
