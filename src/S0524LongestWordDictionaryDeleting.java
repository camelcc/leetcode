import java.util.Comparator;
import java.util.List;

public class S0524LongestWordDictionaryDeleting {
    public String findLongestWord(String s, List<String> d) {
        d.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o2.length() - o1.length();
                }
            }
        });

        for (String ds : d) {
            if (contains(s, ds)) {
                return ds;
            }
        }
        return "";
    }

    private boolean contains(String s, String d) {
        int si = 0, di = 0;
        while (di < d.length()) {
            while (si < s.length() && s.charAt(si) != d.charAt(di)) {
                si++;
            }
            if (si == s.length()) {
                break;
            }

            si++;
            di++;
        }
        return di == d.length();
    }
}
