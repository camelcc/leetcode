import java.util.ArrayList;
import java.util.List;

public class S0229MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int m1 = 0, m2 = 1, c1 = 0, c2 = 0;
        int N = nums.length;
        for (int n : nums) {
            if (n == m1) {
                c1++;
            } else if (n == m2) {
                c2++;
            } else if (c1 == 0) {
                m1 = n;
                c1 = 1;
            } else if (c2 == 0) {
                m2 = n;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        // count m1, m2
        c1 = 0;
        c2 = 0;
        for (int n : nums) {
            if (n == m1) {
                c1++;
            } else if (n == m2) {
                c2++;
            }
        }

        List<Integer> res = new ArrayList<>();
        if (c1 > N/3) {
            res.add(m1);
        }
        if (c2 > N/3) {
            res.add(m2);
        }
        return res;
    }
}
