public class S0831MaskingPersonalInformation {
    public String maskPII(String S) {
        S = S.toLowerCase().trim();
        StringBuilder sb = new StringBuilder();
        if (S.contains("@")) {
            // email
            int i = S.indexOf('@');
            String t = S.substring(0, i);
            sb.append(t.charAt(0)).append("*****").append(t.charAt(t.length()-1)).append(S.substring(i));
        } else {
            // phone
            for (char c : S.toCharArray()) {
                if (Character.isDigit(c)) {
                    sb.append(c);
                }
            }
            StringBuilder t = new StringBuilder();
            for (int i = 0; i < sb.length(); i++) {
                t.append(i < (sb.length()-4) ? '*' : sb.charAt(i));
            }
            sb = t;
            if (sb.length() > 10) {
                sb.insert(sb.length()-10, '-');
                sb.insert(0, '+');
            }
            sb.insert(sb.length()-7, '-');
            sb.insert(sb.length()-4, '-');
        }
        return sb.toString();
    }
}
