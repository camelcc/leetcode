public class S1974MinimumTimeTypeWordUsingSpecialTypewriter {
    public int minTimeToType(String word) {
        int p = 0, res = 0;
        for (char c : word.toCharArray()) {
            int cp = c-'a';
            if (p != cp) {
                res += Math.min(Math.abs(p-cp), Math.abs(26-Math.abs(p-cp)));
                p = cp;
            }
            res++;
        }
        return res;
    }
}
