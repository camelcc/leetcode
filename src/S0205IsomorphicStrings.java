import java.util.HashMap;

public class S0205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> m1 = new HashMap<>();
        HashMap<Character, Character> m2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (m1.containsKey(c1)) {
                if (c2 != m1.get(c1)) {
                    return false;
                }
            } else {
                if (m2.containsKey(c2)) {
                    return false;
                }

                m1.put(c1, c2);
                m2.put(c2, c1);
            }
        }
        return true;
    }
}
