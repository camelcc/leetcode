import java.util.Arrays;

public class S1402ReducingDishes {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        if (satisfaction[satisfaction.length-1] <= 0) {
            return 0;
        }
        int[] postSum = new int[satisfaction.length];
        int s = 0;
        for (int i = satisfaction.length-1; i >= 0; i--) {
            postSum[i] += satisfaction[i]+s;
            s = postSum[i];
        }

        int res = 0;
        int i = Arrays.binarySearch(satisfaction, 0);
        if (i < 0) {
            i = -(i+1);
        }
        while (i > 0 && satisfaction[i-1] >= 0) {
            i--;
        }
        int max = 0, time = 1;
        for (int j = i; j < satisfaction.length; j++) {
            max += satisfaction[j]*time;
            time++;
        }
        while (i >= 0 && max > res) {
            res = max;
            i--;
            if (i >= 0) {
                max += postSum[i];
            }
        }

        return res;
    }
}
