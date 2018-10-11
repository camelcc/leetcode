import java.util.Arrays;

public class S0455AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;
        int cookieIndex = s.length-1;
        int childIndex = g.length-1;
        while (cookieIndex >= 0 && childIndex >= 0) {
            if (s[cookieIndex] < g[childIndex]) {
                childIndex--;
                continue;
            }
            cookieIndex--;
            childIndex--;
            res++;
        }
        return res;
    }
}
