import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class S1996NumberWeakCharactersGame {
    public int numberOfWeakCharacters(int[][] properties) {
        int res = 0;
        Arrays.sort(properties, Comparator.comparingInt(o -> o[0]));
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        int currentAttack = properties[0][0], i = 0;
        while (i < properties.length) {
            TreeMap<Integer, Integer> freq = new TreeMap<>();
            while (i < properties.length && properties[i][0] == currentAttack) {
                int defense = properties[i][1];
                while (!cnt.isEmpty() && cnt.firstKey() < defense) {
                    res += cnt.remove(cnt.firstKey());
                }
                freq.put(defense, freq.getOrDefault(defense, 0)+1);
                i++;
            }
            if (i < properties.length) {
                currentAttack = properties[i][0];
            }
            for (int k : freq.keySet()) {
                cnt.put(k, cnt.getOrDefault(k, 0)+freq.get(k));
            }
        }
        return res;
    }
}
