public class S1684CountNumberConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] chars = new boolean[26];
        for (char c : allowed.toCharArray()) {
            chars[c-'a'] = true;
        }
        int res = 0;
        for (String w : words) {
            boolean good = true;
            for (char c : w.toCharArray()) {
                if (!chars[c-'a']) {
                    good = false;
                    break;
                }
            }
            if (good) {
                res++;
            }
        }
        return res;
    }
}
