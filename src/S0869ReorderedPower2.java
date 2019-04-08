import java.util.Arrays;
import java.util.HashSet;

public class S0869ReorderedPower2 {
    public boolean reorderedPowerOf2(int N) {
        HashSet<String> p2s = new HashSet<>();
        int p = 1;
        for (int i = 0; i < 31; i++) {
            char[] digits = String.valueOf(p << i).toCharArray();
            Arrays.sort(digits);
            p2s.add(new String(digits));
        }

        char[] digits = String.valueOf(N).toCharArray();
        Arrays.sort(digits);
        return p2s.contains(new String(digits));
    }
}
