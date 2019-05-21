import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0639DecodeWaysII {
    public int numDecodings(String s) {
        int MOD = (int)Math.pow(10, 9)+7;
        long times = 1;
        char[] sc = s.toCharArray();
        for (int i = sc.length-1; i >= 0; i--) {
            if (sc[i] != '0') {
                continue;
            }
            if (i > 0 && sc[i-1] == '*') {
                sc[i-1] = '1';
                times *= 2;
                times = times%MOD;
            }
        }
        HashMap<String, Integer> dp = new HashMap<>();
        dp.put("0", 0);
        times = times * decode(sc, dp);
        times = times % MOD;
        return (int)times;
    }

    private int decode(char[] sc, HashMap<String, Integer> dp) {
        int MOD = (int)Math.pow(10, 9)+7;
        List<String> segs = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sc.length; i++) {
            sb.append(sc[i]);
            if (sc[i] == '0' || (sc[i] >= '3' && sc[i] <= '9')) {
                segs.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        if (sb.length() > 0) {
            segs.add(sb.toString());
        }

        long res = 1;
        for (String seg : segs) {
            res *= decodeSeg(seg, dp);
            res = res % MOD;
        }
        return (int)res;
    }

    private int decodeSeg(String s, HashMap<String, Integer> dp) {
        if (dp.containsKey(s)) {
            return dp.get(s);
        }
        assert !s.isEmpty();
        char c = s.charAt(0);
        if (s.length() == 1) {
            int res = c == '*' ? 9: 1;
            dp.put(s, res);
            return res;
        }
        // [1|2|*]+0, [1|2|*]+[3-9], [1|2|*]+*
        // s.len >= 2
        assert c == '1' || c == '2' || c == '*';
        char n = s.charAt(1);
        if (n == '0') {
            assert s.length() == 2;
            int res = c == '*' ? 2 : 1;
            dp.put(s, res);
            return res;
        }

        // [1|2|*]+[3-9]
        if (n >= '3' && n <= '9') {
            assert s.length() == 2;
            int res = 0;
            if (n <= '6') {
                if (c == '1' || c == '2') {
                    res = 2;
                } else if (c == '*') {
                    res = 11;
                }
            } else { // [1|*]7,8,9
                if (c == '1') {
                    res = 2;
                } else if (c == '2') {
                    res = 1;
                } else if (c == '*') {
                    res = 10;
                }
            }
            dp.put(s, res);
            return res;
        }

        int MOD = (int)Math.pow(10, 9)+7;
        long res = decodeSeg(s.substring(1), dp);
        long post = s.length() == 2 ? 1 : decodeSeg(s.substring(2), dp);

        // [1|2|*]+[1|2|*]
        if (n == '1' || n == '2') {
            if (c == '1' || c == '2') {
                res += post;
            } else if (c == '*') {
                res *= 9;
                res = res%MOD;
                res += 2 * post;
            }
            res = res%MOD;
            dp.put(s, (int)res);
            return (int)res;
        }

        assert n == '*';
        if (c == '1' || c == '2') {
            if (c == '1') {
                res += 9*post;
            } else if (c == '2') {
                res += 6*post;
            }
        } else if (c == '*') {
            res *= 9;
            res = res%MOD;
            res += 15*post;
        }
        res = res%MOD;
        dp.put(s, (int)res);
        return (int)res;
    }
}
