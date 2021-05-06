public class S1694ReformatPhoneNumber {
    public String reformatNumber(String number) {
        StringBuilder res = new StringBuilder();
        StringBuilder cur = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (c < '0' || c > '9') {
                continue;
            }
            if (cur.length() == 4) {
                res.append(cur.charAt(0)).append(cur.charAt(1)).append(cur.charAt(2)).append('-');
                char t = cur.charAt(3);
                cur = new StringBuilder();
                cur.append(t).append(c);
            } else {
                cur.append(c);
            }
        }
        if (cur.length() <= 3) {
            res.append(cur);
        } else {
            res.append(cur.charAt(0)).append(cur.charAt(1)).append('-').append(cur.charAt(2)).append(cur.charAt(3));
        }
        return res.toString();
    }
}
