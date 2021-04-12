import java.util.ArrayList;
import java.util.List;

public class S1638CountSubstringsThatDifferOneCharacter {
    int countSubstrings(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        int count = 0;
        for(int i=0;i<lenS;i++) {
            for(int j=0;j<lenT;j++) {
                int diff = 0;
                for(int m=i,n=j ; m<lenS && n < lenT ; m++,n++) {
                    if(s.charAt(m) != t.charAt(n)) {
                        diff++;
                    }
                    if(diff == 1) {
                        count++;
                    }
                    if(diff == 2) {
                        break;
                    }
                }
            }
        }
        return count;
    }
}
