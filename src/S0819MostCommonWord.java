import java.util.Arrays;
import java.util.HashMap;

public class S0819MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("[!?',;\\.]", " ");
        Arrays.sort(banned);

        HashMap<String, Integer> maps = new HashMap<>();
        int max = 0;
        String m = "";

        for (String s : paragraph.split(" ")) {
            if (s.isEmpty() || s.equals(" ") || Arrays.binarySearch(banned, s) >= 0) {
                continue;
            }

            maps.put(s, maps.getOrDefault(s, 0) + 1);
            if (maps.get(s) > max) {
                max = maps.get(s);
                m = s;
            }
        }

        return m;
    }
}
