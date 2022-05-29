public class S2283CheckNumberHasEqualDigitCountDigitValue {
    public boolean digitCount(String num) {
        int[] cnt = new int[10];
        for (char c : num.toCharArray()) {
            cnt[c-'0']++;
        }
        for (int i = 0; i < num.length(); i++) {
            if (cnt[i] != num.charAt(i)-'0') {
                return false;
            }
        }
        return true;
    }
}
