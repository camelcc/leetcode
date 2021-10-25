public class S2047NumberValidWordsSentence {
    public int countValidWords(String sentence) {
        int res = 0;
        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split(" ")) {
            if (word.isBlank()) {
                continue;
            }
            boolean valid = true;
            boolean hypened = false;
            boolean marked = false;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (Character.isDigit(c)) {
                    valid = false;
                    break;
                }
                if (c == '-') {
                    if (hypened || i == 0 || i == word.length()-1) {
                        valid = false;
                        break;
                    }
                    hypened = true;
                }
                if (c == '!' || c == ',' || c == '.') {
                    if (marked || i != word.length()-1 || (i > 0 && word.charAt(i-1) == '-')) {
                        valid = false;
                        break;
                    }
                    marked = true;
                }
            }
            if (valid) {
                res++;
            }
        }
        return res;
    }
}
