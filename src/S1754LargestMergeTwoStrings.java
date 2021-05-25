public class S1754LargestMergeTwoStrings {
    public String largestMerge(String word1, String word2) {
        return largest(word1, word2, 0, 0);
    }

    private String largest(String word1, String word2, int wi1, int wi2) {
        if (wi1 == word1.length() && wi2 == word2.length()) {
            return "";
        }
        if (wi1 == word1.length()) {
            return word2.substring(wi2);
        }
        if (wi2 == word2.length()) {
            return word1.substring(wi1);
        }
        char c1 = word1.charAt(wi1), c2 = word2.charAt(wi2);
        if (c1 < c2) {
            return c2 + largest(word1, word2, wi1, wi2+1);
        } else if (c1 == c2) {
            String s1 = word1.substring(wi1+1);
            String s2 = word2.substring(wi2+1);
            if (s1.compareTo(s2) >= 0) {
                return c1+largest(word1, word2, wi1+1, wi2);
            } else {
                return c2+largest(word1, word2, wi1, wi2+1);
            }
        } else { // c1 > c2
            return c1 + largest(word1, word2, wi1+1, wi2);
        }
    }
}
