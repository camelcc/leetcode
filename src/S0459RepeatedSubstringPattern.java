public class S0459RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.length() % (i+1) != 0) {
                continue;
            }
            int times = s.length()/(i+1);
            String sub = s.substring(0, i+1);
            if (!s.endsWith(sub)) {
                continue;
            }
            StringBuilder n = new StringBuilder();
            for (int j = 0; j < times; j++) {
                n.append(sub);
            }
            if (n.toString().equals(s)) {
                return true;
            }
        }

        return false;
    }
}
