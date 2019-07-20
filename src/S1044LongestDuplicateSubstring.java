import java.util.HashSet;

public class S1044LongestDuplicateSubstring {
    public String longestDupSubstring(String S) {
        String res = "";
        int lo = 1, hi = S.length();
        while (lo < hi) {
            int mid = lo+(hi-lo)/2;
            String dup = dup(S, mid);
            if (dup != null && dup.length() == mid) {
                res = dup;
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return res;
    }

    private String dup(String S, int len) {
        HashSet<Long> set = new HashSet<>();
        long hash=0, p=1;
        long mod=Long.MAX_VALUE/26;
        for(int i=0;i < len; i++){
            hash=(26*hash+(S.charAt(i)-'a'))%mod;
            p=(p*26)%mod;
        }
        set.add(hash);
        for (int i = 0; i < S.length()-len; i++) {
            hash=(hash*26+(S.charAt(i+len)-'a')-((S.charAt(i)-'a')*p))%mod;
            if(hash<0) hash+=mod;
            if(set.contains(hash)){
                return S.substring(i+1,i+len+1);
            }
            set.add(hash);
        }
        return null;
    }
}
