public class S1768MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < word1.length() && i < word2.length()) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }
        if (i >= word1.length() && i >= word2.length()) {
            return sb.toString();
        }
        if (i >= word1.length()) {
            sb.append(word2.substring(i));
        }
        if (i >= word2.length()) {
            sb.append(word1.substring(i));
        }
        return sb.toString();
    }
}
