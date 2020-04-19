import java.util.ArrayList;
import java.util.List;

public class S1417ReformatTheString {
    public String reformat(String s) {
        List<Character> chars = new ArrayList<>();
        List<Character> digits = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.add(c);
            } else {
                chars.add(c);
            }
        }
        int diff = Math.abs(chars.size()-digits.size());
        if (diff > 2) {
            return "";
        } else if (diff == 2) {
            if (chars.isEmpty() || digits.isEmpty()) {
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        if (digits.size() >= chars.size()) {
            sb.append(digits.get(0));
            digits.remove(0);
            while (!chars.isEmpty() && !digits.isEmpty()) {
                sb.append(chars.get(0));
                chars.remove(0);
                sb.append(digits.get(0));
                digits.remove(0);
            }
        } else {
            sb.append(chars.get(0));
            chars.remove(0);
            while (!chars.isEmpty() && !digits.isEmpty()) {
                sb.append(digits.get(0));
                digits.remove(0);
                sb.append(chars.get(0));
                chars.remove(0);
            }
        }
        if (!chars.isEmpty()) {
            sb.append(chars.get(0));
        }
        if (!digits.isEmpty()) {
            sb.append(digits.get(0));
        }
        return sb.toString();
    }
}
