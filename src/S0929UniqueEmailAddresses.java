import java.util.HashSet;

public class S0929UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> res = new HashSet<>();
        for (String email : emails) {
            int p = email.indexOf('@');
            String local = email.substring(0, p);
            int plus = local.indexOf('+');
            if (plus != -1) {
                local = local.substring(0, plus);
            }
            StringBuilder sb = new StringBuilder();
            for (char c : local.toCharArray()) {
                if (c != '.') {
                    sb.append(c);
                }
            }
            res.add(sb.toString() + email.substring(p));
        }
        return res.size();
    }
}
