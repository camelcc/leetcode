public class S1310XORQueriesSubarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xor = new int[arr.length];
        xor[0] = arr[0];
        int cur = arr[0];
        for (int i = 1; i < arr.length; i++) {
            cur = cur ^ arr[i];
            xor[i] = cur;
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 0) {
                res[i] = xor[queries[i][1]];
            } else {
                res[i] = xor[queries[i][0]-1] ^ xor[queries[i][1]];
            }
        }

        return res;
    }
}
