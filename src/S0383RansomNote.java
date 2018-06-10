import java.util.HashMap;

public class S0383RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> mag = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (!mag.containsKey(c)) {
                mag.put(c, 1);
            } else {
                mag.put(c, mag.get(c) + 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!mag.containsKey(c)) {
                return false;
            }
            if (mag.get(c) <= 1) {
                mag.remove(c);
            } else {
                mag.put(c, mag.get(c) - 1);
            }
        }
        return true;
    }
}
