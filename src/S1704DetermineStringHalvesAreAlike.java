import java.util.HashSet;

public class S1704DetermineStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        char[] v = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        HashSet<Character> vowels = new HashSet<>();
        for (char c : v) {
            vowels.add(c);
        }

        int cnt = 0;
        for (int i = 0; i < s.length()/2; i++) {
            if (vowels.contains(s.charAt(i))) {
                cnt++;
            }
        }
        for (int i = s.length()/2; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }
}
