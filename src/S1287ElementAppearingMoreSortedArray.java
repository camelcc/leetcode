public class S1287ElementAppearingMoreSortedArray {
    public int findSpecialInteger(int[] arr) {
        int threshold = arr.length/4;
        int prev = -1, cnt = 0;
        for (int a : arr) {
            if (prev == a) {
                cnt++;
            } else {
                prev = a;
                cnt = 1;
            }
            if (cnt > threshold) {
                return prev;
            }
        }
        return -1;
    }
}
