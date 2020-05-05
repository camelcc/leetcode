import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class S1432MaxDifferenceYouCanGetFromChangingInteger {
    public int maxDiff(int num) {
        String n = String.valueOf(num);
        HashSet<Integer> res = new HashSet<>();
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                String next = n.replace((char)('0'+x), (char)('0'+y));
                if (next.startsWith("0")) {
                    continue;
                }
                res.add(Integer.parseInt(next));
            }
        }
        ArrayList<Integer> array = new ArrayList<>(res);
        Collections.sort(array);
        return array.get(array.size()-1) - array.get(0);
    }
}
