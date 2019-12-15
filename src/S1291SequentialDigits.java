import java.util.ArrayList;
import java.util.List;

public class S1291SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        int loLen = String.valueOf(low).length();
        int hiLen = String.valueOf(high).length();
        String candidate = "123456789";
        List<Integer> res = new ArrayList<>();
        for (int len = loLen; len <= hiLen; len++) {
            for (int p = 0; p+len <= 9; p++) {
                int v = Integer.parseInt(candidate.substring(p, p+len));
                if (v >= low && v <= high) {
                    res.add(v);
                }
            }
        }
        return res;
    }
}
