public class S2114MaximumNumberWordsFoundSentences {
    public int mostWordsFound(String[] sentences) {
        int res = 0;
        for (String sentence : sentences) {
            int len = sentence.split(" ").length;
            res = Math.max(res, len);
        }
        return res;
    }
}
