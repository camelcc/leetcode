public class S1130MinimumCostTreeFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        int[][] sum = new int[arr.length][arr.length];
        int[][] max = new int[arr.length][arr.length];
        return mct(arr, 0, arr.length-1, sum, max)[0];
    }

    private int[] mct(int[] arr, int left, int right, int[][] mct, int[][] max) {
        assert left <= right;
        if (mct[left][right] != 0) {
            return new int[]{mct[left][right], max[left][right]};
        }

        int[] res = null;
        if (left == right) {
            res = new int[]{0, Math.max(arr[left], arr[right])};
        } else if (left+1 == right) {
            res = new int[]{arr[left]*arr[right], Math.max(arr[left], arr[right])};
        } else {
            int m = arr[left], sum = Integer.MAX_VALUE;
            for (int i = left; i < right; i++) {
                int[] l = mct(arr, left, i, mct, max);
                int[] r = mct(arr, i+1, right, mct, max);
                sum = Math.min(sum, l[0]+r[0]+l[1]*r[1]);
                m = Math.max(l[1], r[1]);
            }
            res = new int[]{sum, m};
        }
        mct[left][right] = res[0];
        max[left][right] = res[1];
        return res;
    }
}
