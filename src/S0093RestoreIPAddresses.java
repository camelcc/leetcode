import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class S0093RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ip = new ArrayList<>();
        if (s.length() < 4) {
            return ip;
        }

        for (Pair<String, String> first : nextIp(s)) {
            for (Pair<String, String> second: nextIp(first.getValue())) {
                for (Pair<String, String> third: nextIp(second.getValue())) {
                    for (Pair<String, String> forth: nextIp(third.getValue())) {
                        if (forth.getValue().isEmpty()) {
                            ip.add(first.getKey() + "." + second.getKey() + "." + third.getKey() + "." + forth.getKey());
                        }
                    }
                }
            }
        }

        return ip;
    }

    private List<Pair<String, String>> nextIp(String s) {
        List<Pair<String, String>> ips = new ArrayList<>();
        if (s.isEmpty()) {
            return ips;
        }

        if (s.startsWith("0")) {
            ips.add(new Pair<>("0", s.substring(1)));
            return ips;
        }

        // 1 digits, 1-9
        ips.add(new Pair<>(s.substring(0, 1), s.substring(1)));

        // 2 digits, 10-99
        if (s.length() >= 2) {
            ips.add(new Pair<>(s.substring(0, 2), s.substring(2)));
        }

        // 3 digits, 100-255
        if (s.length() >= 3) {
            int v = Integer.valueOf(s.substring(0, 3));
            if (v <= 255) {
                ips.add(new Pair<>(s.substring(0, 3), s.substring(3)));
            }
        }

        return ips;
    }
}
