import java.util.Arrays;

public class S1354ConstructTargetArrayWithMultipleSums {
    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }

        long sum = 0;
        for (int t : target) {
            sum += t;
        }

        while (true) {
            Arrays.sort(target);
            if (target[target.length-1] == 1 && target[0] == 1) {
                return true;
            }

            int last = target[target.length-1];
            if (last <= sum-last) {
                return false;
            }
            target[target.length-1] = last-(int)(sum-last);
            sum -= (sum-last);
        }
    }
}
