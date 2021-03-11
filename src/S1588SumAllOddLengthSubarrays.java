public class S1588SumAllOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] sum = new int[arr.length+1];
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
            sum[i+1] = s;
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j+= 2) {
                // [i, j]
                res += sum[j+1]-sum[i];
            }
        }
        return res;
    }
}
