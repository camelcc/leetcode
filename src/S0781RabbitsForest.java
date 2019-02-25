import java.util.HashMap;

public class S0781RabbitsForest {
    public int numRabbits(int[] answers) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : answers) {
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        for (int key : map.keySet()) {
            res += (int)(Math.ceil(1.0*map.get(key)/(key+1))) * (key+1);
        }
        return res;
    }
}
