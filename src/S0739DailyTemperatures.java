public class S0739DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        if (T.length == 0) {
            return res;
        }
        res[T.length-1] = 0;

        for (int i = T.length-2; i >= 0; i--) {
            if (T[i] < T[i+1]) {
                res[i] = 1;
            } else {
                int j = i+1;
                while (j < T.length && res[j] != 0) {
                    if (T[i] < T[j+res[j]]) {
                        res[i] = j+res[j]-i;
                        break;
                    } else {
                        j = j + res[j];
                    }
                }
            }
        }

        return res;
    }
}
