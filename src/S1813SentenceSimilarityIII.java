public class S1813SentenceSimilarityIII {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        if (s1.length > s2.length) {
            String[] t = s2;
            s2 = s1;
            s1 = t;
        }
        // s1.len <= s2.len, insert into s1
        int l = 0, r1 = s1.length-1, r2 = s2.length-1;
        while (l <= r1 && s1[l].equals(s2[l])) {
            l++;
        }
        if (l > r1) {
            return true;
        }
        while (r1 >= l && s1[r1].equals(s2[r2])) {
            r1--;
            r2--;
        }
        if (l > r1) {
            return true;
        }
        // l <= r
        return false;
    }
}
