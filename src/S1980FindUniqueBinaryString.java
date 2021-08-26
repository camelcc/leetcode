import java.util.HashSet;

public class S1980FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<Integer> candidates = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            candidates.add(i);
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < nums.length) {
            int size = (0x1<<(nums.length-i))/2;
            HashSet<Integer> zeros = new HashSet<>();
            for (int p : candidates) {
                if (nums[p].charAt(i) == '0') {
                    zeros.add(p);
                }
            }
            if (zeros.size() < size) {
                sb.append('0');
                candidates = zeros;
            } else {
                sb.append('1');
                for (int z : zeros) {
                    candidates.remove(z);
                }
            }
            i++;
        }
        return sb.toString();
    }
}
