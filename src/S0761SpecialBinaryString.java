import java.util.*;

public class S0761SpecialBinaryString {
    public String makeLargestSpecial(String S) {
        int height = 0, start = 0;
        List<String> mountains = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '1') {
                height++;
            } else if (c == '0') {
                height--;
            }
            if (height == 0) {
                mountains.add("1" + makeLargestSpecial(S.substring(start+1, i-1)) + "0");
                start = i+1;
            }
        }
        mountains.sort(Comparator.reverseOrder());
        return String.join("", mountains);
    }
}
