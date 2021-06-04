public class S1832CheckSentencePangram {
    public boolean checkIfPangram(String sentence) {
        boolean[] exist = new boolean[26];
        for (char c : sentence.toCharArray()) {
            exist[c-'a'] = true;
        }
        for (int i = 0; i < 26; i++) {
            if (!exist[i]) {
                return false;
            }
        }
        return true;
    }
}
