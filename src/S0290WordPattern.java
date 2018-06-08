import java.util.HashMap;

public class S0290WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        if (pattern.length() == 0) {
            return false;
        }

        HashMap<Character, String> patternMapping = new HashMap<>();
        HashMap<String, Character> wordMapping = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            if (patternMapping.containsKey(p)) {
                if (!words[i].equals(patternMapping.get(p))) {
                    return false;
                }
            } else {
                if (wordMapping.containsKey(words[i])) {
                    return false;
                }

                patternMapping.put(p, words[i]);
                wordMapping.put(words[i], p);
            }
        }
        return true;
    }
}
