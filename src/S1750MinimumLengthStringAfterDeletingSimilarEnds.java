public class S1750MinimumLengthStringAfterDeletingSimilarEnds {
    public int minimumLength(String s) {
        int l = 0, r = s.length()-1;
        while (l < r) {
            int dl = l, dr = r;
            char cl = s.charAt(dl), cr = s.charAt(dr);
            if (cl != cr) {
                break;
            }

            while (dl < s.length() && s.charAt(dl) == cl) {
                dl++;
            }
            while (dr >= 0 && s.charAt(dr) == cr) {
                dr--;
            }
            if (dl > dr) {
                return 0;
            } else if (dl == dr) {
                return 1;
            }
            // dl < dr
            l = dl;
            r = dr;
        }
        return r-l+1;
    }
}
