public class S0953VerifyingAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] alpha = new int[26];
        for (int i = 0; i < order.length(); i++) {
            alpha[order.charAt(i)-'a'] = i;
        }
        for (int i = 0; i < words.length-1; i++) {
            int l = 0;
            while (l < words[i].length()) {
                if (l >= words[i+1].length()) {
                    return false;
                }
                char ca = words[i].charAt(l);
                char cb = words[i+1].charAt(l);
                if (alpha[ca-'a'] < alpha[cb-'a']) {
                    break;
                } else if (alpha[words[i].charAt(l)-'a'] > alpha[words[i+1].charAt(l)-'a']) {
                    return false;
                }
                l++;
            }
        }
        return true;
    }
}
