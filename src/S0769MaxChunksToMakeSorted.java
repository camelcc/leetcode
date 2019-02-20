public class S0769MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        if (arr.length <= 1) {
            return arr.length;
        }

        int[] len = new int[arr.length];
        int[] min = new int[arr.length];
        min[arr.length-1] = arr[arr.length-1];
        len[arr.length-1] = 1;
        for (int i = arr.length-2; i >= 0; i--) {
            if (arr[i] < min[i+1]) {
                min[i] = arr[i];
                len[i] = 1;
                continue;
            }

            min[i] = min[i+1];

            int j = i+1;
            while (j < arr.length && arr[i] >= min[j]) {
                j += len[j];
            }
            len[i] = j-i;
        }

        int res = 0;
        int i = 0;
        while (i < arr.length) {
            res++;
            i += len[i];
        }
        return res;
    }
}
