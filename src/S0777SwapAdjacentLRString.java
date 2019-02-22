public class S0777SwapAdjacentLRString {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }
        if (start.equals(end)) {
            return true;
        }

        int startLR = 0;
        while (startLR < start.length() && start.charAt(startLR) == 'X') {
            startLR++;
        }
        int endLR = 0;
        while (endLR < end.length() && end.charAt(endLR) == 'X') {
            endLR++;
        }
        if (startLR == start.length()) {
            return endLR == end.length();
        }
        if (endLR == end.length()) {
            return startLR == start.length();
        }
        if (start.charAt(startLR) != end.charAt(endLR)) {
            return false;
        }

        if (startLR < endLR) {
            if (start.charAt(startLR) == 'L') {
                return false;
            } else { //'R'
                String tend = end.substring(startLR, endLR) + end.substring(endLR+1);
                return canTransform(start.substring(startLR+1), tend);
            }
        } else if (startLR == endLR) {
            return canTransform(start.substring(startLR+1), end.substring(endLR+1));
        } else { // startLR > endLR
            if (start.charAt(startLR) == 'R') {
                return false;
            } else {  // 'L'
                String tstart = start.substring(endLR, startLR) + start.substring(startLR+1);
                return canTransform(tstart, end.substring(endLR+1));
            }
        }
    }
}
