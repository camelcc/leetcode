public class S0972EqualRationalNumbers {
    public boolean isRationalEqual(String S, String T) {
        String[] s = simplify(S);
        String[] t = simplify(T);
        if (!s[2].equals(t[2]) && s[2].length() != t[2].length()) {
            String small = s[2].length() < t[2].length() ? s[2] : t[2];
            String big = s[2].length() > t[2].length() ? s[2] : t[2];
            if (small.length() > 0 && big.length()%small.length() == 0) {
                String sb = "";
                for (int i = 0; i < big.length()/small.length(); i++) {
                    sb = sb + small;
                }
                if (big.equals(sb)) {
                    s[2] = "";
                    t[2] = "";
                }
            }
        }
        return s[0].equals(t[0]) && s[1].equals(t[1]) && s[2].equals(t[2]);
    }

    private String[] simplify(String S) {
        String repeat = "";
        if (S.indexOf('(') != -1) {
            int l = S.indexOf('('), r = S.indexOf(')');
            repeat = S.substring(l+1, r);
            assert repeat.length() <= 4;
            if (repeat.length() == 2 &&
                    repeat.charAt(0) == repeat.charAt(1)) {
                repeat = repeat.substring(1);
            } else if (repeat.length() == 3 &&
                    repeat.charAt(0) == repeat.charAt(1) &&
                    repeat.charAt(1) == repeat.charAt(2)) {
                repeat = repeat.substring(2);
            } else if (repeat.length() == 4 &&
                    repeat.charAt(0) == repeat.charAt(1) &&
                    repeat.charAt(1) == repeat.charAt(2) &&
                    repeat.charAt(2) == repeat.charAt(3)) {
                repeat = repeat.substring(3);
            }
        }
        if (repeat.equals("0")) {
            repeat = "";
        }
        String nonrepeat = "";
        if (S.indexOf('.') != -1 && S.indexOf('.') != S.length()-1) {
            nonrepeat = S.substring(S.indexOf('.')+1, S.indexOf('(') == -1 ? S.length() : S.indexOf('('));
            while (!repeat.isEmpty() &&
                    !nonrepeat.isEmpty() &&
                    nonrepeat.charAt(nonrepeat.length()-1) == repeat.charAt(repeat.length()-1)) {
                repeat = repeat.charAt(repeat.length()-1)+repeat.substring(0, repeat.length()-1);
                nonrepeat = nonrepeat.substring(0, nonrepeat.length()-1);
            }
            while (repeat.isEmpty() && !nonrepeat.isEmpty() && nonrepeat.endsWith("0")) {
                nonrepeat = nonrepeat.substring(0, nonrepeat.length()-1);
            }
        }
        String integer = S;
        if (S.indexOf('.') != -1) {
            integer = S.substring(0, S.indexOf('.'));
        }
        if (repeat.length() == 1 && repeat.charAt(0) == '9') {
            if (!nonrepeat.isEmpty()) {
                while (nonrepeat.endsWith("9")) {
                    nonrepeat = nonrepeat.substring(0, nonrepeat.length()-1);
                }
                if (nonrepeat.isEmpty()) {
                    integer = String.valueOf(Integer.valueOf(integer)+1);
                } else {
                    char[] t = nonrepeat.toCharArray();
                    t[t.length-1]++;
                    nonrepeat = new String(t);
                }
            } else {
                integer = String.valueOf(Integer.valueOf(integer)+1);
            }
            repeat = "";
        }
        if (nonrepeat.equals("0")) {
            nonrepeat = "";
        }
        return new String[] {integer, nonrepeat, repeat};
    }
}
