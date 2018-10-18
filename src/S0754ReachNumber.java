public class S0754ReachNumber {
    public int reachNumber(int target) {
        if (target == 0) {
            return 0;
        }

        int steps = 0;
        int current = 0;
        if (target > 0) {
            while (current < target) {
                steps++;
                current += steps;
            }
            while ((current-target)%2 == 1) {
                steps++;
                current += steps;
            }
        } else {
            while (current > target) {
                steps++;
                current -= steps;
            }
            while ((target-current)%2 == 1) {
                steps++;
                current -= steps;
            }
        }
        return steps;
    }
}
