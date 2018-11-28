public class S0413ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int cnt = 0;

        int start = 0;
        while (start < A.length-2) {
            int diff = A[start+1]-A[start];
            int i = start+1;
            while (i < A.length && A[i]-A[i-1] == diff) {
                i++;
            }
            int len = i-start;
            if (len < 3) {
                start++;
            } else {
                for (int j = 2; j <= len-1; j++) {
                    cnt += (len-j);
                }
                start = i;
            }
        }
        return cnt;
    }
}
