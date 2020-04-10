import java.util.HashMap;

public class S1399CountLargestGroup {
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 0);
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0, v = i;
            while (v != 0) {
                sum += v%10;
                v = v/10;
            }
            cnt.put(sum, cnt.getOrDefault(sum, 0)+1);
            if (cnt.get(sum) > max) {
                max = cnt.get(sum);
            }
        }
        int res = 0;
        for (int c : cnt.values()) {
            if (c == max) {
                res++;
            }
        }
        return res;
    }
}
