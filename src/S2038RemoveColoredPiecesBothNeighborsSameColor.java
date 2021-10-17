public class S2038RemoveColoredPiecesBothNeighborsSameColor {
    public boolean winnerOfGame(String colors) {
        int cntA = 0, cntB = 0, cnt = 0;
        char c = colors.charAt(0);
        for (char color : colors.toCharArray()) {
            if (color == c) {
                cnt++;
            } else {
                if (cnt >= 3) {
                    if (c == 'A') {
                        cntA += cnt-2;
                    } else if (c == 'B') {
                        cntB += cnt-2;
                    }
                }
                c = color;
                cnt = 1;
            }
        }
        if (cnt >= 3) {
            if (c == 'A') {
                cntA += cnt-2;
            } else if (c == 'B') {
                cntB += cnt-2;
            }
        }
        if (cntA == 0 || cntA <= cntB) {
            return false;
        } else {
            return true;
        }
    }
}
