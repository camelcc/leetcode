import java.util.ArrayList;
import java.util.List;

public class S0119PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        for (int k = 0; k < rowIndex; k++) {
            List<Integer> now = new ArrayList<>();
            now.add(1);
            for (int i = 0; i < prev.size()-1; i++) {
                now.add(prev.get(i) + prev.get(i+1));
            }
            now.add(1);

            prev = now;
        }
        return prev;
    }
}
