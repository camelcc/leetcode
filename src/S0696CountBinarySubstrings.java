public class S0696CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int cnt = 0;
        if (s.length() == 0) {
            return cnt;
        }
        int preCnt = 1;
        int currentCnt = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                currentCnt++;
            } else {
                preCnt = currentCnt;
                currentCnt = 1;
            }
            if (currentCnt <= preCnt) {
                cnt++;
            }
        }
        return cnt;
    }
}
