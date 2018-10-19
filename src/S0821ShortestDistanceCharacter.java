import java.util.Arrays;

public class S0821ShortestDistanceCharacter {
    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        Arrays.fill(res, S.length());

        int pos = -S.length()-1;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == C) {
                res[i] = 0;

                int start = (i+pos)/2+1;
                if (start < 0) {
                    start = 0;
                }
                for (int j = start; j < i; j++) {
                    res[j] = i-j;
                }
                pos = i;
            } else {
                res[i] = i-pos;
            }
        }
        return res;
    }
}
