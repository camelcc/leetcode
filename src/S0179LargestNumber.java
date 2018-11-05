import java.util.Arrays;
import java.util.Comparator;

public class S0179LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return "";
        }
        String[] n = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            n[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(n, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String v1 = s1+s2;
                String v2 = s2+s1;
                return v2.compareTo(v1);
            }
        });
        if (n[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : n) {
            sb.append(s);
        }
        return sb.toString();
    }
}
