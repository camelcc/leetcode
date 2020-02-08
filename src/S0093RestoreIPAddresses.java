import java.util.ArrayList;
import java.util.List;

public class S0093RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<List<String>> ips = splitIP(s, 4);
        List<String> res = new ArrayList<>();
        for (List<String> ip : ips) {
            StringBuilder sb = new StringBuilder();
            for (String i : ip) {
                sb.append(i);
                sb.append('.');
            }
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
        }
        return res;
    }

    private List<List<String>> splitIP(String s, int num) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() < num) {
            return res;
        }
        if (num < 0) {
            return res;
        } else if (num == 1) {
            if (s.length() > 3 || Integer.parseInt(s) > 255 || (s.length() > 1 && s.startsWith("0"))) {
                return res;
            }
            List<String> r = new ArrayList<>();
            r.add(s);
            res.add(r);
            return res;
        }


        // 1 digits
        for (List<String> r : splitIP(s.substring(1), num-1)) {
            r.add(0, s.substring(0, 1));
            res.add(r);
        }

        // 2 digits
        if (!s.startsWith("0") && s.length() > 2) {
            for (List<String> r : splitIP(s.substring(2), num-1)) {
                r.add(0, s.substring(0, 2));
                res.add(r);
            }
        }

        // 3 digits
        if (!s.startsWith("0") && s.length() > 3) {
            String t = s.substring(0, 3);
            if (Integer.parseInt(t) <= 255) {
                for (List<String> r : splitIP(s.substring(3), num-1)) {
                    r.add(0, t);
                    res.add(r);
                }
            }
        }

        return res;
    }
}
