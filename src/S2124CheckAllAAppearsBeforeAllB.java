public class S2124CheckAllAAppearsBeforeAllB {
    public boolean checkString(String s) {
        char pre = 'a';
        for (char c : s.toCharArray()) {
            if (pre == 'b' && c == 'a') {
                return false;
            }
            pre = c;
        }
        return true;
    }
}
