public class S1456MaximumNumberVowelsSubstringGivenLength {
    public int maxVowels(String s, int k) {
        int res = 0;

        int e = 0;
        while (e < k && e < s.length()) {
            char c = s.charAt(e);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                res++;
            }
            e++;
        }

        int i = 1;
        int cnt = res;
        while (i + k <= s.length()) {
            char c = s.charAt(i-1);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cnt--;
            }
            char n = s.charAt(i+k-1);
            if (n == 'a' || n == 'e' || n == 'i' || n == 'o' || n == 'u') {
                cnt++;
            }
            i++;
            res = Math.max(res, cnt);
        }
        return res;
    }
}
