import java.util.Arrays;

public class S1092ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        String lcs = lcs(str1, str2);
        if (lcs.isEmpty()) {
            return str1+str2;
        }
        int p1 = 0, p2 = 0, pc = 0;
        StringBuilder sb = new StringBuilder();
        while (pc < lcs.length()) {
            char c = lcs.charAt(pc);
            while (p1 < str1.length() && str1.charAt(p1) != c) {
                sb.append(str1.charAt(p1));
                p1++;
            }
            while (p2 < str2.length() && str2.charAt(p2) != c) {
                sb.append(str2.charAt(p2));
                p2++;
            }
            sb.append(c);
            p1++;
            p2++;
            pc++;
        }
        if (p1 < str1.length()) {
            sb.append(str1.substring(p1));
        }
        if (p2 < str2.length()) {
            sb.append(str2.substring(p2));
        }
        return sb.toString();
    }

    private String lcs(String a, String b) {
        String[][] dp = new String[a.length()+1][b.length()+1];
        Arrays.fill(dp[0], "");
        for (int i = 1; i <= a.length(); i++) {
            dp[i][0] = "";
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + a.charAt(i-1);
                } else {
                    if (dp[i-1][j].length() < dp[i][j-1].length()) {
                        dp[i][j] = dp[i][j-1];
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}
