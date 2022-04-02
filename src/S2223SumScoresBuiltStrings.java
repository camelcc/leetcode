// https://leetcode.com/problems/sum-of-scores-of-built-strings/discuss/1907390/Java-or-Z-Algorithm
public class S2223SumScoresBuiltStrings {
    public long sumScores(String s) {
        char[] ca= s.toCharArray();
        int n= ca.length, x= 0, y= 0;
        int[] z= new int[n];
        long ans= n;
        for(int i= 1; i<n; i++) {
            z[i]= Math.max(0, Math.min(z[i-x], y-i+1));
            while(i+z[i] < n && ca[z[i]] == ca[i+z[i]]){
                x= i; y= i+z[i]; z[i]++;
            }
            ans+= z[i];
        }
        return ans;
    }
}
