public class S0748ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = cnt(licensePlate);

        String shortest = null;
        for (String word : words) {
            int[] cnt = cnt(word);
            boolean valid = true;
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0 && count[i] > cnt[i]) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                if (shortest == null) {
                    shortest = word;
                } else if (shortest.length() > word.length()) {
                    shortest = word;
                }
            }
        }
        return shortest;
    }

    private int[] cnt(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                count[c-'a']++;
            } else if (c >= 'A' && c <= 'Z') {
                count[c-'A']++;
            }
        }
        return count;
    }
}
