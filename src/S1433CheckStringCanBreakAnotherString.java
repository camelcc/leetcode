import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S1433CheckStringCanBreakAnotherString {
    public boolean checkIfCanBreak(String s1, String s2) {
        List<Character> c1 = new ArrayList<>();
        for (char c : s1.toCharArray()) {
            c1.add(c);
        }
        Collections.sort(c1);
        List<Character> c2 = new ArrayList<>();
        for (char c : s2.toCharArray()) {
            c2.add(c);
        }
        Collections.sort(c2);
        boolean can = true;
        for (int i = c1.size()-1; i >= 0; i--) {
            if (c1.get(i) < c2.get(i)) {
                can = false;
                break;
            }
        }
        if (can) {
            return true;
        }
        can = true;
        for (int i = c1.size()-1; i >= 0; i--) {
            if (c2.get(i) < c1.get(i)) {
                can = false;
                break;
            }
        }
        return can;
    }
}
