import java.util.HashSet;

public class S1839LongestSubstringAllVowelsOrder {
    public int longestBeautifulSubstring(String word) {
        HashSet<Character> vowels = new HashSet<>();
        int res = 0;
        int start = 0;
        while (start < word.length()) {
            int end = start;
            vowels.add(word.charAt(end));
            while (end+1 < word.length() && word.charAt(end+1) >= word.charAt(end)) {
                end++;
                vowels.add(word.charAt(end));
            }
            if (vowels.size() == 5) {
                res = Math.max(res, end-start+1);
            }
            if (end == word.length()-1) {
                break;
            }
            start = end+1;
            vowels = new HashSet<>();
        }
        return res;
    }
}
