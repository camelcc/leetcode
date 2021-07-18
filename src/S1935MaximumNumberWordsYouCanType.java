public class S1935MaximumNumberWordsYouCanType {
    public int canBeTypedWords(String text, String brokenLetters) {
        int res = 0;
        boolean[] broken = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            broken[c-'a'] = true;
        }
        for (String word : text.split(" ")) {
            boolean good = true;
            for (char c : word.toCharArray()) {
                if (broken[c-'a']) {
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
