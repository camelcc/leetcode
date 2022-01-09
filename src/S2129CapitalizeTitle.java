public class S2129CapitalizeTitle {
    public String capitalizeTitle(String title) {
        StringBuilder res = new StringBuilder();
        String[] words = title.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            if (word.length() <= 2) {
                res.append(word);
            } else {
                char[] wc = word.toCharArray();
                wc[0] = (char)('A' + (wc[0] - 'a'));
                res.append(String.valueOf(wc));
            }
            if (i < words.length-1) {
                res.append(" ");
            }
        }
        return res.toString();
    }
}
