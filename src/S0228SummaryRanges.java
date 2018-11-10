import java.util.ArrayList;
import java.util.List;

public class S0228SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        int start = nums[0];
        int current = start;
        int end = 1;
        while (end < nums.length) {
            if (current != Integer.MAX_VALUE && current+1 == nums[end]) {
                current++;
            } else {
                res.add(current == start ? String.valueOf(start) : start+"->"+current);
                start = nums[end];
                current = start;
            }
            end++;
        }
        res.add(current == start ? String.valueOf(start) : start+"->"+current);
        return res;
    }
}
