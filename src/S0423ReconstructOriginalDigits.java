import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class S0423ReconstructOriginalDigits {
    public String originalDigits(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c-'a']++;
        }


        String[] numbers = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        HashMap<Character, List<Integer>> digitChars = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            for (char c : numbers[i].toCharArray()) {
                if (!digitChars.containsKey(c)) {
                    digitChars.put(c, new ArrayList<>());
                }
                if (!digitChars.get(c).contains(i)) {
                    digitChars.get(c).add(i);
                }
            }
        }

        boolean containsSingleCount = true;
        StringBuilder sb = new StringBuilder();

        while (containsSingleCount) {
            containsSingleCount = false;
            for (char c : digitChars.keySet()) {
                if (digitChars.get(c).size() == 1) {
                    containsSingleCount = true;

                    int num = digitChars.get(c).get(0);
                    int times = charCounts[c - 'a'];
                    int[] remains = Arrays.copyOf(charCounts, charCounts.length);
                    for (char ch : numbers[num].toCharArray()) {
                        remains[ch-'a'] -= times;
                    }
                    charCounts = remains;
                    for (int i = 0; i < times; i++) {
                        sb.append(String.valueOf(num));
                    }
                    for (List<Integer> v : digitChars.values()) {
                        v.remove((Integer)num);
                    }
                    break;
                }
            }
            for (int i = 0; i < 26; i++) {
                char c = (char)('a' + i);
                if (digitChars.containsKey(c) && digitChars.get(c).isEmpty()) {
                    digitChars.remove(c);
                }
            }
        }
        char[] digits = sb.toString().toCharArray();
        Arrays.sort(digits);
        return String.valueOf(digits);
    }
}
