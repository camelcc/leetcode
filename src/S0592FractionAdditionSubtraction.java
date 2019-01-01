import java.util.ArrayList;
import java.util.List;

public class S0592FractionAdditionSubtraction {
    public String fractionAddition(String expression) {
        if (expression.isEmpty()) {
            return "";
        }

        List<int[]> values = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(expression.charAt(0));
        for (int i = 1; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-') {
                values.add(parse(sb.toString()));
                ops.add(c);
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        values.add(parse(sb.toString()));

        int[] res = values.remove(0);
        while (!ops.isEmpty()) {
            int[] sec = values.remove(0);
            int[] fir = res;
            char op = ops.remove(0);
            int n = fir[1]*sec[1];
            int d;
            if (op == '+') {
                d = fir[0]*sec[1]+fir[1]*sec[0];
            } else if (op == '-') {
                d = fir[0]*sec[1]-fir[1]*sec[0];
            } else {
                throw new IllegalArgumentException("invalid ops");
            }
            res = new int[]{d, n};
        }

        boolean nag = false;
        if (res[0] < 0 && res[1] > 0) {
            nag = true;
            res[0] = - res[0];
        } else if (res[0] > 0 && res[1] < 0) {
            nag = true;
            res[1] = - res[1];
        } else {
            if (res[0] < 0) {
                res[0] = -res[0];
            }
            if (res[1] < 0) {
                res[1] = - res[1];
            }
        }
        int gcd = gcd(res[0], res[1]);
        return (nag ? "-" : "") + String.valueOf(res[0]/gcd) + "/" + String.valueOf(res[1]/gcd);
    }

    private int[] parse(String ex) {
        String[] vs = ex.split("/");
        int[] n = new int[2];
        n[0] = Integer.valueOf(vs[0]);
        n[1] = Integer.valueOf(vs[1]);
        return n;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        int x = a%b;
        return gcd(b, x);
    }
}
