public class S1915NumberWonderfulSubstrings {
    public long wonderfulSubstrings(String word) {
        long res = 0;
        int[] cnt = new int[(0x1<<10)+1];
        cnt[0] = 1;
        int pre = 0;
        for (char c : word.toCharArray()) {
            int v = c-'a';
            pre = pre^(0x1<<v);

            for (int i = 0; i < 10; i++) {
                res += cnt[pre^(0x1<<i)];
            }
            res += cnt[pre];
            cnt[pre]++;
        }
        return res;
    }
}
