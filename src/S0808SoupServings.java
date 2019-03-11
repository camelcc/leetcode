import java.util.HashMap;

public class S0808SoupServings {
    private HashMap<Integer, HashMap<Integer, Double>> map;

    public double soupServings(int N) {
        if (N > 6000) {
            return 1;
        }
        map = new HashMap<>();
        return serve(N, N, 1.0);
    }

    private double serve(int a, int b, double p) {
        if (map.containsKey(a) && map.get(a).containsKey(b)) {
            return map.get(a).get(b);
        }

        double res = p;
        if (a == 0 && b == 0) {
            res = 0.5*p;
        } else if (a == 0 && b > 0) {
            res = p;
        } else if (a > 0 && b == 0) {
            res = 0;
        } else if (a > 0 && b > 0) {
            double t = 0.25*p;
            res = 0;
            res += serve(a>100?a-100:0, b, t);
            res += serve(a>75?a-75:0, b>25?b-25:0, t);
            res += serve(a>50?a-50:0, b>50?b-50:0, t);
            res += serve(a>25?a-25:0, b>75?b-75:0, t);
        }

        if (!map.containsKey(a)) {
            map.put(a, new HashMap<>());
        }
        if (!map.get(a).containsKey(b)) {
            map.get(a).put(b, res);
        }

        return res;
    }
}
