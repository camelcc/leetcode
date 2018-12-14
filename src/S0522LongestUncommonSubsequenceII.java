import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class S0522LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o2.length()-o1.length();
                }
            }
        });

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            if ((i > 0 && strs[i-1].equals(strs[i])) ||
                    (i < strs.length-1 && strs[i].equals(strs[i+1]))) {
                set.add(s);
                continue;
            }
            boolean contains = false;
            for (String l : set) {
                if (contains(l, s)) {
                    contains = true;
                    break;
                }
            }
            if (contains) {
                set.add(s);
                continue;
            }

            return s.length();
        }
        return -1;
    }

    private boolean contains(String larger, String smaller) {
        int si = 0, li = 0;
        while (si < smaller.length()) {
            char sc = smaller.charAt(si);
            while (li < larger.length() && larger.charAt(li) != sc) {
                li++;
            }
            if (li == larger.length()) {
                return false;
            }
            si++;
            li++;
        }
        return si == smaller.length();
    }
}
