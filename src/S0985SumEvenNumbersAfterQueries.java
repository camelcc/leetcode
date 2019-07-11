public class S0985SumEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[queries.length];
        int even = 0, p = 0;
        for (int a : A) {
            if (a%2 == 0) {
                even += a;
            }
        }
        for (int[] query : queries) {
            int v = query[0], i = query[1];
            int t = A[i]+v;
            if (t%2 == 0) {
                if (A[i]%2 == 0) {
                    even = even - A[i] + t;
                } else {
                    even += t;
                }
            } else {
                if (A[i]%2 == 0) {
                    even -= A[i];
                }
            }
            A[i] = t;
            res[p++] = even;
        }
        return res;
    }
}
