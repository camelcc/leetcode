import java.util.ArrayList;
import java.util.List;

public class S1313DecompressRunLengthEncodedList {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int a = nums[i], b = nums[i+1];
            for (int t = 0; t < a; t++) {
                list.add(b);
            }
            i += 2;
        }
        int[] res = new int[list.size()];
        for (int t = 0; t < list.size(); t++) {
            res[t] = list.get(t);
        }
        return res;
    }
}
