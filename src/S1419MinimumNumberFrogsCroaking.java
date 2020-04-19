public class S1419MinimumNumberFrogsCroaking {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int cntc = 0, cntr = 0, cnto = 0, cnta = 0, cntk = 0;
        int res = 0;
        int current = 0;
        for (char c : croakOfFrogs.toCharArray()) {
            if (c == 'c') {
                cntc++;
                current++;
                res = Math.max(res, current);
            } else if (c == 'r') {
                cntr++;
                if (cntr > cntc) {
                    return -1;
                }
            } else if (c == 'o') {
                cnto++;
                if (cnto > cntr) {
                    return -1;
                }
            } else if (c == 'a') {
                cnta++;
                if (cnta > cnto) {
                    return -1;
                }
            } else if (c == 'k') {
                cntk++;
                if (cntk > cnta) {
                    return -1;
                }
                current--;
            }
        }
        if (cntc != cntr || cntc != cnto || cntc != cnta || cntc != cntk) {
            return -1;
        }
        return res;
    }
}
