public class S0667BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        if (k >= n) {
            return null;
        }
        int[] res = new int[n];
        int i = 0;
        int left = 1, right = n;
        while (left <= right) {
            if (k <= 0) {
                res[i++] = left++;
            } else {
                if ((k % 2) == 1) {
                    res[i++] = left++;
                } else {
                    res[i++] = right--;
                }
                k--;
            }
        }

        return res;
    }
}
