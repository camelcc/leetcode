public class S2315CountAsterisks {
    public int countAsterisks(String s) {
        boolean in = false;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '|') {
                in = !in;
            } else if (c == '*') {
                if (!in) {
                    res++;
                }
            }
        }

        return res;
    }
}
