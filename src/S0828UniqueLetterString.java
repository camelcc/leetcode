public class S0828UniqueLetterString {
    public int uniqueLetterString(String S) {
        if (S.isEmpty()) {
            return 0;
        }
        int N = S.length();
        int MOD = (int)Math.pow(10, 9)+7;
        long res = 0;

        int[] lastPosition = new int[26];
        int[] contribution = new int[26];
        int current = 0;

        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);
            current -= contribution[c-'A'];
            contribution[c-'A'] = (i-(lastPosition[c-'A']-1));
            current += contribution[c-'A'];
            lastPosition[c-'A'] = i+1;
            res += current;
        }
        return (int)(res%MOD);
    }
}
