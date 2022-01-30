import java.util.Stack;

public class S2156FindSubstringWithGivenHashValue {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long pk = 1;
        for (int i = 1; i < k; i++) {
            pk = (pk*power)%modulo;
        }

        long hash = 0;
        for (int i = s.length()-1; i >= s.length()-k; i--) {
            int val = s.charAt(i)-'a'+1;
            hash = (hash*power + val)%modulo;
        }

        int res = (hash == hashValue ? s.length()-k : s.length());
        for (int i = s.length()-k-1; i >= 0; i--) {
            int end = s.charAt(i+k)-'a'+1;
            int val = s.charAt(i)-'a'+1;
            hash = (hash + (modulo-pk)*end)%modulo;
            hash = (hash * power + val)%modulo;
            if (hash == hashValue) {
                res = i;
            }
        }
        return s.substring(res, res+k);
    }
}
