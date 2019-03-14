import java.util.ArrayList;
import java.util.List;

public class S0816AmbiguousCoordinates {
    public List<String> ambiguousCoordinates(String S) {
        S = S.substring(1, S.length()-1);
        List<String> res = new ArrayList<>();
        for (int i = 1; i < S.length(); i++) {
            List<String> left = comb(S.substring(0, i));
            List<String> right = comb(S.substring(i));
            for (String l : left) {
                for (String r : right) {
                    res.add("("+l+", "+r+")");
                }
            }
        }
        return res;
    }

    private List<String> comb(String digits) {
        assert !digits.isEmpty();
        List<String> res = new ArrayList<>();
        if (digits.length() == 1) {
            res.add(digits);
            return res;
        }

        if (digits.startsWith("0")) {
            if (!digits.endsWith("0")) {
                res.add("0."+digits.substring(1));
            }
        } else {
            res.add(digits);
            if (!digits.endsWith("0")) {
                for (int i = 1; i < digits.length(); i++) {
                    res.add(digits.substring(0, i)+"."+digits.substring(i));
                }
            }
        }
        return res;
    }
}
