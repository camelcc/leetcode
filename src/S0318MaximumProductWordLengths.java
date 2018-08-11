import java.util.Arrays;
import java.util.Comparator;

public class S0318MaximumProductWordLengths {
    public int maxProduct(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        int max = 0;

        for (int i = 0; i < words.length-1; i++) {
            String first = words[i];
            String tmp = words[i+1];
            if (first.length() * tmp.length() <= max) {
                break;
            }

            for (int j = i+1; j < words.length; j++) {
                String second = words[j];
                int m = first.length() * second.length();
                if (m <= max) {
                    break;
                }

                if (containsCommons(first, second)) {
                    continue;
                }

                max = m;
            }
        }
        return max;
    }

    private boolean containsCommons(String a, String b) {
        int[] letters = new int[26];
        for (char c : a.toCharArray()) {
            letters[c - 'a']++;
        }

        for (char c : b.toCharArray()) {
            if (letters[c - 'a'] > 0) {
                return true;
            }
        }

        return false;
    }
}
