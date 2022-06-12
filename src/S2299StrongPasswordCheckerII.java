import java.util.HashSet;

public class S2299StrongPasswordCheckerII {
    public boolean strongPasswordCheckerII(String password) {
        int len = 0;
        boolean lower = false;
        boolean upper = false;
        boolean digit = false;
        boolean special = false;
        HashSet<Character> set = new HashSet();
        for (char c : "!@#$%^&*()-+".toCharArray()) {
            set.add(c);
        }

        char prev = 0;
        for (char c : password.toCharArray()) {
            if (c == prev) {
                return false;
            }
            if (c >= 'a' && c <= 'z') {
                lower = true;
            } else if (c >= 'A' && c <= 'Z') {
                upper = true;
            } else if (set.contains(c)) {
                special = true;
            } else if (c >= '0' && c <= '9') {
                digit = true;
            }

            prev = c;
            len++;
        }

        return len >= 8 && lower && upper && digit && special;
    }
}
