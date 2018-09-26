public class S0424LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int max = 0;

        int maxCount = 0;
        int[] count = new int[26];
        int start = 0;
        int end = 0;
        for (end = 0; end < s.length(); end++) {
            count[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(end) - 'A']);
            if (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;

                maxCount = 0;
                for (int i = 0; i < 26; i++) {
                    if (maxCount < count[i]) {
                        maxCount = count[i];
                    }
                }
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
