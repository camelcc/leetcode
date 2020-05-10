import java.util.ArrayList;
import java.util.List;

public class S1441BuildArrayWithStackOperations {
    public List<String> buildArray(int[] target, int n) {
        int current = 1;
        List<String> res = new ArrayList<>();
        for (int t : target) {
            while (current < t) {
                res.add("Push");
                res.add("Pop");
                current++;
            }
            assert current == t;
            res.add("Push");
            current++;
        }
        return res;
    }
}
