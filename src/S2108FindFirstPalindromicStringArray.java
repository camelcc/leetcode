public class S2108FindFirstPalindromicStringArray {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            int l = 0, r = word.length()-1;
            while (l < r) {
                if (word.charAt(l) != word.charAt(r)) {
                    break;
                }
                l++;
                r--;
            }
            if (l < r) {
                continue;
            }
            return word;
        }
        return "";
    }
}
