public class S0880DecodedStringIndex {
    public String decodeAtIndex(String S, int K) {
        long len = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c >= 'a' && c <= 'z') {
                len++;
                if (len == K) {
                    return String.valueOf(c);
                }
            } else {
                int t = (c-'0');
                if (len * t >= K) {
                    return decodeAtIndex(S.substring(0, i), (int)((K-1)%len)+1);
                } else {
                    len = len * t;
                }
            }
        }
        return "";
    }
}
