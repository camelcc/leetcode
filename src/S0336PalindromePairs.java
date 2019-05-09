import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0336PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Boolean> dp = new HashMap<>();
        String[] reverse = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            reverse[i] = sb.reverse().toString();
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String pre = words[i];
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }

                String post = reverse[j];

                int prei = 0, posti = 0;
                boolean valid = true;
                while (prei < pre.length() && posti < post.length()) {
                    if (pre.charAt(prei) != post.charAt(posti)) {
                        valid = false;
                        break;
                    }

                    prei++;
                    posti++;
                }
                if (!valid) {
                    continue;
                }

                // prei >= pre.len || posti >= post.len
                if (prei < pre.length()) {
                    if (!isPalindrome(pre.substring(prei), dp)) {
                        continue;
                    }
                } else if (posti < post.length()) {
                    if (!isPalindrome(post.substring(posti), dp)) {
                        continue;
                    }
                }

                List<Integer> t = new ArrayList<>();
                t.add(i);
                t.add(j);
                res.add(t);
            }
        }
        return res;
    }

    private boolean isPalindrome(String str, HashMap<String, Boolean> dp) {
        if (dp.containsKey(str)) {
            return dp.get(str);
        }

        boolean res = true;
        int lo = 0, hi = str.length()-1;
        char[] c = str.toCharArray();
        while (lo < hi) {
            if (c[lo] != c[hi]) {
                res = false;
                break;
            }
            lo++;
            hi--;
        }
        dp.put(str, res);
        return res;
    }
}
