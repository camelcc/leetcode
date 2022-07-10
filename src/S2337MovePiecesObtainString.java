public class S2337MovePiecesObtainString {
    public boolean canChange(String start, String target) {
        StringBuilder sstart = new StringBuilder();
        for (char c : start.toCharArray()) {
            if (c != '_') {
                sstart.append(c);
            }
        }
        StringBuilder starget = new StringBuilder();
        for (char c : target.toCharArray()) {
            if (c != '_') {
                starget.append(c);
            }
        }
        String sstr = sstart.toString();
        String tstr = starget.toString();
        if (!sstr.equals(tstr)) {
            return false;
        }

        // scan L
        int si = 0, ti = 0;
        while (si < start.length()) {
            if (start.charAt(si) != 'L') {
                si++;
                continue;
            }

            while (ti < target.length()) {
                if (target.charAt(ti) != 'L') {
                    ti++;
                    continue;
                } else {
                    break;
                }
            }

            if (si < ti) {
                return false;
            }

            si++;
            ti++;
        }

        // scan R
        si = 0;
        ti = 0;
        while (si < start.length()) {
            if (start.charAt(si) != 'R') {
                si++;
                continue;
            }

            while (ti < target.length()) {
                if (target.charAt(ti) != 'R') {
                    ti++;
                    continue;
                } else {
                    break;
                }
            }

            if (si > ti) {
                return false;
            }

            si++;
            ti++;
        }

        return true;
    }
}
