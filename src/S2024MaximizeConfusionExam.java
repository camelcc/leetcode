public class S2024MaximizeConfusionExam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(max(answerKey, k, 'T'), max(answerKey, k, 'F'));
    }

    private int max(String data, int k, char m) {
        int l = 0, r = 0, c = k;
        while (r < data.length()) {
            if (data.charAt(r) != m) {
                if (c == 0) {
                    break;
                } else {
                    c--;
                }
            }
            r++;
        }
        int res = r-l;
        while (r < data.length()) {
            r++;
            while (r < data.length() && data.charAt(r) == m) {
                r++;
            }
            while (data.charAt(l) == m) {
                l++;
            }
            l++;

            res = Math.max(res, r-l);
        }
        res = Math.max(res, r-l);
        return res;
    }
}
