public class S1525NumberGoodWaysSplitString {
    public int numSplits(String s) {
        int[] right = new int[26];
        for (char c : s.toCharArray()) {
            right[c-'a']++;
        }
        int[] left = new int[26];
        int res = 0;
        for (char c : s.toCharArray()) {
            left[c-'a']++;
            right[c-'a']--;
            if (equals(left, right)) {
                res++;
            }
        }
        return res;
    }

    private boolean equals(int[] left, int[] right) {
        int cl = 0, cr = 0;
        for (int i = 0; i < 26; i++) {
            if (left[i] > 0) {
                cl++;
            }
            if (right[i] > 0) {
                cr++;
            }
        }
        return cl == cr;
    }
}
