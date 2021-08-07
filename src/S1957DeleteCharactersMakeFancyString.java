public class S1957DeleteCharactersMakeFancyString {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        char cur = '\0';
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c != cur) {
                while (cnt > 0) {
                    sb.append(cur);
                    cnt--;
                }
                cnt = 1;
                cur = c;
            } else {
                if (cnt < 2) {
                    cnt++;
                }
            }
        }
        while (cnt > 0) {
            sb.append(cur);
            cnt--;
        }
        return sb.toString();
    }
}
