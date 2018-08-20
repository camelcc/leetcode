public class S0392IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }

        int sposition = 0;
        int tposition = 0;
        while (tposition < t.length()) {
            if (t.charAt(tposition) == s.charAt(sposition)) {
                tposition++;
                sposition++;
                if (sposition == s.length()) {
                    return true;
                }
            } else {
                tposition++;
            }
        }
        return false;
    }
}
