import java.util.ArrayList;
import java.util.List;

public class S0017LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        List<String> chars = new ArrayList<>();
        int num = Integer.valueOf(digits.substring(0, 1));
        switch (num) {
            case 2:
                chars.add("a");
                chars.add("b");
                chars.add("c");
                break;
            case 3:
                chars.add("d");
                chars.add("e");
                chars.add("f");
                break;
            case 4:
                chars.add("g");
                chars.add("h");
                chars.add("i");
                break;
            case 5:
                chars.add("j");
                chars.add("k");
                chars.add("l");
                break;
            case 6:
                chars.add("m");
                chars.add("n");
                chars.add("o");
                break;
            case 7:
                chars.add("p");
                chars.add("q");
                chars.add("r");
                chars.add("s");
                break;
            case 8:
                chars.add("t");
                chars.add("u");
                chars.add("v");
                break;
            case 9:
                chars.add("w");
                chars.add("x");
                chars.add("y");
                chars.add("z");
                break;
            default:
                break;
        }
        List<String> rest = letterCombinations(digits.substring(1));
        if (rest.isEmpty()) {
            return chars;
        }

        for (String c : chars) {
            for (String r : rest) {
                res.add(c+r);
            }
        }
        return res;
    }
}
