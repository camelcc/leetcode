import java.util.ArrayList;
import java.util.List;

public class S0784LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        int cnt = 1;
        char[] str = S.toLowerCase().toCharArray();
        for (char c : str) {
            if (c >= 'a' && c <= 'z') {
                cnt *= 2;
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            res.add(new String(str));
            increment(str);
        }
        return res;
    }

    private void increment(char[] s) {
        int c = 1;
        for (int i = 0; i < s.length; i++) {
            char ch = s[i];
            if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))){
                continue;
            }
            if (ch >= 'a' && ch <= 'z') {
                s[i] = (char)('A' + ch - 'a');
                return;
            }

            if (ch >= 'A' && ch <= 'Z') {
                s[i] = (char)('a' + ch - 'A');
            }
        }
    }
}