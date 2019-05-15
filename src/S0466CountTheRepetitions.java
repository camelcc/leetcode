import java.util.HashMap;
import java.util.HashSet;

public class S0466CountTheRepetitions {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        HashSet<Character> s1sets = new HashSet<>();
        for (char c : s1.toCharArray()) {
            s1sets.add(c);
        }
        for (char c : s2.toCharArray()) {
            if (!s1sets.contains(c)) {
                return 0;
            }
        }
        HashMap<Character, Integer>[] pos = new HashMap[s1.length()];
        for (int i = 0; i < s1.length(); i++) {
            pos[i] = new HashMap<>();
            char c = s1.charAt(i);
            pos[i].put(c, i);
            for (int j = i-1; j >= 0 && !pos[j].containsKey(c); j--) {
                pos[j].put(c, i);
            }
        }

        int s1Times = 0;
        int s1Index = 0;
        int s2Index = 0;
        int s2Times = 0;
        while (s1Times < n1) {
            char c = s2.charAt(s2Index);
            s1Index = pos[s1Index].getOrDefault(c, -1);
            if (s1Index == -1) {
                s1Times++;
                s1Index = 0;
            } else {
                if (s1Index == s1.length()-1) {
                    s1Index = 0;
                    s1Times++;
                } else {
                    s1Index++;
                }
                if (s2Index == s2.length()-1) {
                    s2Times++;
                    s2Index = 0;
                } else {
                    s2Index++;
                }

                if (s1Index == 0 && s2Index == 0 && s1Times * 2 <= n1) {
                    // each s1times of s1 can match s2times of s2
                    int t1 = s1Times * (n1 / s1Times);
                    int t2 = s2Times * (n1 / s1Times);
                    s1Times = t1;
                    s2Times = t2;
                }
            }
        }
        return s2Times/n2;
    }
}
