import java.util.ArrayList;
import java.util.List;

public class S0733FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0 || image[0].length == 0) {
            return image;
        }
        int M = image.length;
        int N = image[0].length;
        int startColor = image[sr][sc];
        if (startColor == newColor) {
            return image;
        }

        List<Integer> pos = new ArrayList<>();
        pos.add(sr*N+sc);
        while (!pos.isEmpty()) {
            int p = pos.remove(0);
            int pr = p/N;
            int pc = p%N;
            image[pr][pc] = newColor;

            if (pc > 0 && image[pr][pc-1] == startColor) {
                pos.add(pr*N+pc-1);
            }
            if (pr > 0 && image[pr-1][pc] == startColor) {
                pos.add((pr-1)*N+pc);
            }
            if (pc < N-1 && image[pr][pc+1] == startColor) {
                pos.add(pr*N+pc+1);
            }
            if (pr < M-1 && image[pr+1][pc] == startColor) {
                pos.add((pr+1)*N+pc);
            }
        }

        return image;
    }
}
