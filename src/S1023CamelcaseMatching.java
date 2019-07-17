import java.util.ArrayList;
import java.util.List;

public class S1023CamelcaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String query : queries) {
            int qi = 0, pi = 0;
            boolean match = true;
            while (qi < query.length()) {
                char qc = query.charAt(qi);
                if (pi < pattern.length() && qc == pattern.charAt(pi)) {
                    pi++;
                } else {
                    if (!Character.isLowerCase(qc)) {
                        match = false;
                        break;
                    }
                }
                qi++;
            }
            if (match && pi < pattern.length()) {
                match = false;
            }
            res.add(match);
        }
        return res;
    }
}
