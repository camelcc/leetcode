public class S0567PermutationString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        int zeros = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                zeros++;
            }
        }

        int i = 0;
        while (i < s1.length()) {
            char c = s2.charAt(i);
            if (count[c-'a'] == 1) {
                zeros++;
            } else if (count[c-'a'] == 0) {
                zeros--;
            }

            count[c-'a']--;
            i++;
        }
        if (zeros == 26) {
            return true;
        }

        int len = s1.length();
        for (; i < s2.length(); i++) {
            char addC = s2.charAt(i);
            char delC = s2.charAt(i-len);
            if (count[delC-'a'] == -1) {
                zeros++;
            } else if (count[delC-'a'] == 0) {
                zeros--;
            }
            count[delC-'a']++;

            if (count[addC-'a'] == 1) {
                zeros++;
            } else if (count[addC-'a'] == 0) {
                zeros--;
            }
            count[addC-'a']--;

            if (zeros == 26) {
                return true;
            }
        }

        return false;
    }
}
