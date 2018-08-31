public class S0468ValidateIPAddress {
    public String validIPAddress(String IP) {
        if (IP.startsWith(".") || IP.startsWith(":") || IP.endsWith(".") || IP.endsWith(":")) {
            return "Neither";
        }

        if (IP.contains(".")) {
            String[] v4 = IP.split("\\.");
            if (v4.length != 4) {
                return "Neither";
            }
            if (validV4(v4)) {
                return "IPv4";
            } else {
                return "Neither";
            }
        } else if (IP.contains(":")) {
            String[] v6 = IP.split(":");
            if (v6.length != 8) {
                return "Neither";
            }

            if (validV6(v6)) {
                return "IPv6";
            } else {
                return "Neither";
            }
        } else {
            return "Neither";
        }
    }

    private boolean validV4(String[] v4) {
        for (String s : v4) {
            if (s.startsWith("0")) {
                if (!s.equals("0")) {
                    return false;
                }
            } else {
                if (s.isEmpty() || s.length() > 3) {
                    return false;
                }
                for (char c : s.toCharArray()) {
                    if (!(c >= '0' && c <= '9')) {
                        return false;
                    }
                }
                int v = Integer.valueOf(s);
                if (v < 0 || v > 255) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validV6(String[] v6) {
        for (String s : v6) {
            if (s.length() > 4 || s.isEmpty()) {
                return false;
            }

            for (char c : s.toLowerCase().toCharArray()) {
                if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f'))) {
                    return false;
                }
            }
        }
        return true;
    }
}
