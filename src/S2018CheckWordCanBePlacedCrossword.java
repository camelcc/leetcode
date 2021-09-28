public class S2018CheckWordCanBePlacedCrossword {
    public boolean placeWordInCrossword(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            if (place(board, r, 0, 1, word)) {
                return true;
            }
        }
        for (int c = 0; c < board[0].length; c++) {
            if (place(board, 0, c, 2, word)) {
                return true;
            }
        }
        return false;
    }

    private boolean place(char[][] board, int r, int c, int dir, String word) {
        int M = board.length, N = board[0].length;
        if ((dir == 1 && N-c < word.length()) || (dir == 2 && M-r < word.length()) || r >= M || c >= N) {
            return false;
        }
        if (board[r][c] == '#') {
            return place(board, dir == 1 ? r : r+1, dir == 1 ? c+1 : c, dir, word);
        }
        if (dir == 1 && c+word.length() < N && board[r][c+word.length()] != '#') {
            int nc = c;
            while (nc < N && board[r][nc] != '#') {
                nc++;
            }
            return place(board, r, nc, dir, word);
        } else if (dir == 2 && r+word.length() < M && board[r+word.length()][c] != '#') {
            int nr = r;
            while (nr < M && board[nr][c] != '#') {
                nr++;
            }
            return place(board, nr, c, dir, word);
        }
        int match = 3; // 0 - none, 1 - left2right, 2 - right2left, 3 - both
        int p = 0;
        while (p < word.length()) {
            char bc = board[dir == 1 ? r : r+p][dir == 1 ? c+p : c];
            if (bc == '#') {
                match = 0;
            } else if (bc != ' ') {
                if (bc != word.charAt(p)) {
                    match = match&0x2; // only right2left
                }
                if (bc != word.charAt(word.length()-1-p)) {
                    match = match&0x1; // only left2right
                }
            }
            if (match == 0) {
                return place(board, dir == 1 ? r : r+word.length(), dir == 1 ? c+word.length() : c, dir, word);
            }
            p++;
        }
        return true;
    }
}
