import java.util.Arrays;

public class S1861RotatingBox {
    public char[][] rotateTheBox(char[][] box) {
        int M = box.length, N = box[0].length;
        char[][] res = new char[N][M];
        for (int r = 0; r < N; r++) {
            Arrays.fill(res[r], '.');
        }
        for (int r = 0; r < M; r++) {
            int cnt = 0;
            for (int c = 0; c < N; c++) {
                if (box[r][c] == '#') {
                    cnt++;
                } else if (box[r][c] == '.') {
                    continue;
                } else if (box[r][c] == '*') {
                    res[c][M-1-r] = '*';
                    int rc = M-1-r, rr = c-1;
                    while (cnt > 0) {
                        res[rr--][rc] = '#';
                        cnt--;
                    }
                }
            }
            int rc = M-1-r, rr = N-1;
            while (cnt > 0) {
                res[rr--][rc] = '#';
                cnt--;
            }
        }
        return res;
    }
}
