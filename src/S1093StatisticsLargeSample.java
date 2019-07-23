public class S1093StatisticsLargeSample {
    public double[] sampleStats(int[] count) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, mode = 0;
        long sum = 0, cnt = 0;
        int[] median_l = null, median_m = null, median_r = null;
        Boolean even = null;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            // initial
            if (even == null) {
                even = count[i]%2 == 0;
                if (even) {
                    median_l = new int[]{i, count[i]/2};
                    median_r = new int[]{i, count[i]/2+1};
                } else {
                    median_m = new int[]{i, count[i]/2};
                }
            } else {
                if (even && count[i]%2 == 0) {
                    median_l = right(count, median_l, count[i]/2);
                    median_m = null;
                    median_r = right(count, median_r, count[i]/2);
                    even = true;
                } else if (even && count[i]%2 == 1) {
                    median_l = null;
                    median_m = right(count, median_r, count[i]/2);
                    median_r = null;
                    even = false;
                } else if (!even && count[i]%2 == 1) {
                    median_l = right(count, median_m, count[i]/2);
                    median_r = right(count, median_m, count[i]/2+1);
                    median_m = null;
                    even = true;
                } else if (!even && count[i]%2 == 0) {
                    median_l = null;
                    median_m = right(count, median_m, count[i]/2);
                    median_r = null;
                    even = false;
                }
            }
            min = Math.min(min, i);
            max = Math.max(max, i);
            sum += i * count[i];
            cnt += count[i];
            if (count[i] > count[mode]) {
                mode = i;
            }
        }
        assert even != null;
        return new double[]{min, max, sum*1.0/cnt, even ? (median_l[0]+median_r[0])*0.5 : median_m[0], mode};
    }

    private int[] right(int[] count, int[] pos, int cnt) {
        int remains = count[pos[0]]-1-pos[1];
        if (remains >= cnt) {
            return new int[]{pos[0], pos[1]+cnt};
        } else {
            int i = pos[0]+1;
            while (i < count.length && count[i] == 0) {
                i++;
            }
            assert i < count.length;
            return right(count, new int[]{i, 0}, cnt-remains-1);
        }
    }
}
