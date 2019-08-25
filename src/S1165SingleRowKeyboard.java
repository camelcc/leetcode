public class S1165SingleRowKeyboard {
    public int calculateTime(String keyboard, String word) {
        int[] index = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            char c = keyboard.charAt(i);
            index[c-'a'] = i;
        }

        int current = 0, res = 0;
        for (char c : word.toCharArray()) {
            res += Math.abs(index[c-'a']-current);
            current = index[c-'a'];
        }
        return res;
    }
}
