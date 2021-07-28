public class S1945SumDigitsStringAfterConvert {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(String.valueOf(c-'a'+1));
        }
        int res = 0;
        k--;
        for (char c : sb.toString().toCharArray()) {
            res += c-'0';
        }
        while (k != 0) {
            int nr = 0;
            while (res != 0) {
                nr += res%10;
                res = res/10;
            }
            k--;
            res = nr;
        }
        return res;
    }
}
