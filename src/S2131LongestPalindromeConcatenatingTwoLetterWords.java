import java.util.HashMap;

public class S2131LongestPalindromeConcatenatingTwoLetterWords {
    public int longestPalindrome(String[] words) {
        int res = 0;
        HashMap<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            String reversed = String.valueOf(new char[]{word.charAt(1), word.charAt(0)});
            if (cnt.containsKey(reversed)) {
                res += 4;
                if (cnt.get(reversed) == 1) {
                    cnt.remove(reversed);
                } else {
                    cnt.put(reversed, cnt.get(reversed)-1);
                }
            } else {
                cnt.put(word, cnt.getOrDefault(word, 0)+1);
            }
        }
        for (String word : cnt.keySet()) {
            String reversed = String.valueOf(new char[]{word.charAt(1), word.charAt(0)});
            if (word.equals(reversed)) {
                res += 2;
                break;
            }
        }
        return res;
    }
}
