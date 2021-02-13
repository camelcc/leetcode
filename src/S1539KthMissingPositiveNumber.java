public class S1539KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int v = 1;
        int p = 0;
        while (k > 0) {
            if (p >= arr.length || arr[p] > v) {
                k--; // missing
            } else { // arr[p] == v
                p++; // not missing
            }
            if (k == 0) { // missing v
                return v;
            }
            v++;

        }
        return v;
    }
}
