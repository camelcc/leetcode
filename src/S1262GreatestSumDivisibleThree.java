import java.util.*;

public class S1262GreatestSumDivisibleThree {
    public int maxSumDivThree(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        List<Integer> ones = new ArrayList<>();
        List<Integer> twos = new ArrayList<>();
        List<Integer> negOnes = new ArrayList<>();
        List<Integer> negTwos = new ArrayList<>();

        for (int num : nums) {
            int r = num%3;
            if (r == -2) {
                negTwos.add(num);
            } else if (r == -1) {
                negOnes.add(num);
            } else if (r == 0) {
                if (num > 0) {
                    res += num;
                }
            } else if (r == 1) {
                res += num;
                ones.add(num);
            } else if (r == 2) {
                res += num;
                twos.add(num);
            }
        }
        Collections.sort(ones);
        Collections.sort(twos);
        negOnes.sort(Comparator.reverseOrder());
        negTwos.sort(Comparator.reverseOrder());

        if (res%3 == 1) {
            int t = 0;
            if (!ones.isEmpty()) {
                t = Math.max(t, res-ones.get(0));
            }
            if (twos.size() >= 2) {
                t = Math.max(t, res-twos.get(0)-twos.get(1));
            }
            if (!negOnes.isEmpty()) {
                t = Math.max(t, res+negOnes.get(0));
            }
            if (negTwos.size() >= 2) {
                t = Math.max(t, res+negTwos.get(0)+negTwos.get(1));
            }
            return t;
        } else if (res%3 == 2) {
            int t = 0;
            if (ones.size() >= 2) {
                t = Math.max(t, res-ones.get(0)-ones.get(1));
            }
            if (!twos.isEmpty()) {
                t = Math.max(t, res-twos.get(0));
            }
            if (!negTwos.isEmpty()) {
                t = Math.max(t, res+negTwos.get(0));
            }
            if (negOnes.size() >= 2) {
                t = Math.max(t, res+negOnes.get(0)+negOnes.get(1));
            }
            return t;
        }

        return res;
    }
}
