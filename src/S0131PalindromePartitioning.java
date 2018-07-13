import java.util.ArrayList;
import java.util.List;

public class S0131PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        if (s.length() == 1) {
            List<String> t = new ArrayList<>();
            t.add(s);
            res.add(t);
            return res;
        }

        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            if (!isPalindrome(left)) {
                continue;
            }

            List<List<String>> right = partition(s.substring(i));
            for (List<String> r : right) {
                r.add(0, left);
                res.add(r);
            }
        }
        if (isPalindrome(s)) {
            List<String> t = new ArrayList<>();
            t.add(s);
            res.add(t);
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        assert s != null;
        if (s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        int left = 0, right = s.length()-1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
