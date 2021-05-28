public class S1784CheckBinaryStringHasMostOneSegmentOnes {
    public boolean checkOnesSegment(String s) {
        boolean end = false;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                end = true;
            } else {
                if (end) {
                    return false;
                }
            }
        }
        return true;
    }
}
