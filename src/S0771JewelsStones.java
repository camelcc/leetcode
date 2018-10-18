import java.util.HashSet;

public class S0771JewelsStones {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> jews = new HashSet<>();
        for (char c : J.toCharArray()) {
            jews.add(c);
        }
        int cnt = 0;
        for (char c : S.toCharArray()) {
            if (jews.contains(c)) {
                cnt++;
            }
        }
        return cnt;
    }
}
