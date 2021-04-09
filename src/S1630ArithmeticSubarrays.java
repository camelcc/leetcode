import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S1630ArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] data = Arrays.copyOfRange(nums, l[i], r[i]+1);
            if (data.length <= 2) {
                res.add(true);
                continue;
            }
            Arrays.sort(data);
            int diff = data[0]-data[1];
            boolean ar = true;
            for (int j = 1; j < data.length-1; j++) {
                if (data[j]-data[j+1] != diff) {
                    ar = false;
                    break;
                }
            }
            res.add(ar);
        }
        return res;
    }
}
