import java.util.HashMap;
import java.util.HashSet;

public class S2306NamingCompany {
    public long distinctNames(String[] ideas) {
        HashSet<String>[] sets = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            sets[i] = new HashSet<>();
        }
        for (String idea : ideas) {
            char c = idea.charAt(0);
            sets[c-'a'].add(idea.substring(1));
        }

        long res = 0;
        for (int a = 0; a < 26; a++) {
            HashSet<String> suffixA = sets[a];
            for (int b = a+1; b < 26; b++) {
                HashSet<String> suffixB = sets[b];

                int common = 0;
                for (String sa : suffixA) {
                    if (suffixB.contains(sa)) {
                        common++;
                    }
                }

                res += 2L*(suffixA.size()-common)*(suffixB.size()-common);
            }
        }
        return res;
    }
}
