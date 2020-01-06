public class S1309DecryptStringAlphabetIntegerMapping {
    public String freqAlphabets(String s) {
        StringBuilder res = new StringBuilder();
        char[] c = s.toCharArray();
        int i = c.length-1;
        while (i >= 0) {
            if (c[i] == '#') {
                int v = (c[i-2]-'0')*10+(c[i-1]-'0');
                char r = (char)('a'+(v-1));
                res.append(r);
                i -= 3;
            } else {
                char r = (char)('a'+(c[i]-'1'));
                res.append(r);
                i--;
            }
        }
        return res.reverse().toString();
    }
}
