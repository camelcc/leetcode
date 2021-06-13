// https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/discuss/1259956/Java-DP-solution.-O(N)-Time-O(N)-space-with-explanation
public class S1888MinimumNumberFlipsMakeBinaryStringAlternating {
    public int minFlips(String s) {
        int[] sWZ = new int[s.length()];
        int[] sWO = new int[s.length()];

        sWZ[s.length()-1] = s.charAt(s.length()-1) == '0' ? 0 : 1;
        sWO[s.length()-1] = s.charAt(s.length()-1) == '0' ? 1 : 0;
        for(int i=s.length()-2;i>=0;i--) {
            sWZ[i] = sWO[i+1] + (s.charAt(i) == '0' ? 0 : 1);
            sWO[i] = sWZ[i+1] + (s.charAt(i) == '0' ? 1 : 0);
        }

        int min = Math.min(sWZ[0],sWO[0]);
        //accounting for rotations
        for(int i=1;i<s.length();i++) {
            int curr = sWZ[i]; //count for substring starting from i
            if((s.length()-i)%2 == 0)
                curr+=(sWZ[0] - (i%2 == 0 ? sWZ[i] : sWO[i])); //count for substring from 0 to i-1 which is rotated
            else
                curr+=(sWO[0] - (i%2 == 0 ? sWO[i] : sWZ[i]));

            int curr2 = sWO[i];
            if((s.length()-i)%2 == 0)
                curr2+=(sWO[0] - (i%2 == 0 ? sWO[i] : sWZ[i]));
            else
                curr2+=(sWZ[0] - (i%2 == 0 ? sWZ[i] : sWO[i]));

            min = Math.min(min,Math.min(curr,curr2));
        }

        return min;
    }
}
