import java.util.HashMap;

public class S2170MinimumOperationsMakeArrayAlternating {
    public int minimumOperations(int[] nums) {
        HashMap<Integer, Integer> even = new HashMap();
        HashMap<Integer, Integer> odd = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (i%2 == 0) {
                even.put(nums[i], even.getOrDefault(nums[i], 0)+1);
            } else {
                odd.put(nums[i], odd.getOrDefault(nums[i], 0)+1);
            }
        }
        int ec1 = 0, ev1 = -1, ec2 = 0, ev2 = -2;
        int oc1 = 0, ov1 = -3, oc2 = 0, ov2 = -4;
        for (int ek : even.keySet()) {
            if (even.get(ek) > ec1) {
                ec2 = ec1;
                ev2 = ev1;
                ec1 = even.get(ek);
                ev1 = ek;
            } else if (even.get(ek) > ec2) {
                ec2 = even.get(ek);
                ev2 = ek;
            }
        }
        for (int ok : odd.keySet()) {
            if (odd.get(ok) > oc1) {
                oc2 = oc1;
                ov2 = ov1;
                oc1 = odd.get(ok);
                ov1 = ok;
            } else if (odd.get(ok) > oc2) {
                oc2 = odd.get(ok);
                ov2 = ok;
            }
        }
        if (ev1 != ov1) {
            return nums.length-ec1-oc1;
        }
        // ev1 == ov1
        return Math.min(nums.length-ec1-oc2, nums.length-oc1-ec2);
    }
}
