import java.util.HashMap;

public class S1742MaximumNumberBallsBox {
    public int countBalls(int lowLimit, int highLimit) {
        int res = 0;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int t = 0;
            int v = i;
            while (v != 0) {
                t += v%10;
                v = v/10;
            }
            cnt.put(t, cnt.getOrDefault(t, 0)+1);
            if (cnt.get(t) > res) {
                res = cnt.get(t);
            }
        }
        return res;
    }
}
