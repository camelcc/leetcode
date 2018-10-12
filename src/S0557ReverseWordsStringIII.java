public class S0557ReverseWordsStringIII {
    public String reverseWords(String s) {
        char[] res = s.toCharArray();
        int wordStart = 0;
        int wordEnd = 0;
        boolean inWord = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (inWord) {
                    inWord = false;
                    wordEnd = i-1;
                    reverse(res, wordStart, wordEnd);
                    wordStart = i;
                } else {
                    wordStart++;
                }
            } else {
                if (inWord) {
                    wordEnd++;
                } else {
                    inWord = true;
                    wordStart = i;
                    wordEnd = i;
                }
            }
        }
        reverse(res, wordStart, wordEnd);
        return new String(res);
    }

    private void reverse(char[] s, int start, int end) {
        if (end <= start) {
            return;
        }
        while (start < end) {
            char t = s[start];
            s[start] = s[end];
            s[end] = t;
            start++;
            end--;
        }
    }
}
