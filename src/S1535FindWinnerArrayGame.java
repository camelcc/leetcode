import java.util.LinkedList;

public class S1535FindWinnerArrayGame {
    public int getWinner(int[] arr, int k) {
        int res = 0;
        if (k >= arr.length-1) {
            // return max
            for (int a : arr) {
                res = Math.max(res, a);
            }
            return res;
        }
        int c = 0;
        int i = 0;
        int v = arr[0];
        int p = 1;
        LinkedList<Integer> q = new LinkedList<>();
        while (i < arr.length) {
            int n = 0;
            if (p < arr.length) {
                n = arr[p++];
            } else {
                n = q.poll();
            }
            if (v >= n) {
                q.offer(n);
            } else {
                q.offer(v);
                v = n;
                c = 0;
            }
            c++;
            if (c >= k) {
                return v;
            }
            i++;
        }
        return v;
    }
}
