import java.util.HashMap;
import java.util.HashSet;

public class S0403FrogJump {
    public boolean canCross(int[] stones) {
        if (stones[0] != 0 && stones[1] != 1) {
            return false;
        }
        HashMap<Integer, HashSet<Integer>> steps = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            steps.put(stones[i], new HashSet<>());
        }
        steps.get(0).add(1);

        for (int i = 0; i < stones.length-1; i++) {
            int stone = stones[i];
            for (int step : steps.get(stone)) {
                int next = stone+step;
                if (!steps.containsKey(next)) {
                    continue;
                }
                if (next == stones[stones.length-1]) {
                    return true;
                }

                if (step > 1) {
                    steps.get(next).add(step-1);
                }
                steps.get(next).add(step);
                steps.get(next).add(step+1);
            }
        }
        return false;
    }
}






























