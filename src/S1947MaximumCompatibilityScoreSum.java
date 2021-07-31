// https://leetcode.com/problems/maximum-compatibility-score-sum/discuss/1370852/Java-Short-DP-%2B-Bitmask
public class S1947MaximumCompatibilityScoreSum {
    public int maxScore(int[][] scores,int[][] dp, int s, int mask){
        if(s == scores.length)
            return 0;
        if(dp[s][mask]!=-1)
            return dp[s][mask];
        int ms = 0;
        for(int i=0;i<scores.length;++i){
            // pair the mentor and student if the bit is set and turn off
            // bit to exclude the mentor for the next student-mentor pair
            if((mask&(1<<i))!=0)
                ms = Math.max(ms,scores[s][i] + maxScore(scores,dp,s+1,mask^(1<<i)));
        }
        return dp[s][mask] = ms;
    }

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int len =  mentors.length, dplen = 1<<len;
        int[][] dp = new int[len][dplen];
        int[][] scores =  new int[len][len];

        for(int i=0;i<len;++i)
            for(int j=0;j<len;++j)
                for(int k=0;k<students[0].length;++k)
                    scores[i][j]+=students[i][k] == mentors[j][k] ? 1 :0;

        for(int i=0;i<len;++i)
            for(int j=0;j<dplen;++j)
                dp[i][j] = -1;
        return maxScore(scores,dp,0,dplen-1);  // a set bit represent mentor is not chosen yet
    }
}
