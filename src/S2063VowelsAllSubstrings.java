public class S2063VowelsAllSubstrings {
    public long countVowels(String word) {
        long res = 0, sum = 0, cnt = 0;
        for (char c : word.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cnt++;
            }
            sum += cnt;
        }
        for (int i = 0; i < word.length(); i++) {
            res += sum;
            char c = word.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                sum -= (word.length()-i);
            }
        }
        return res;
    }
}
