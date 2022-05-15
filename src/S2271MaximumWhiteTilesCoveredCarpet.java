import java.util.Arrays;
import java.util.Comparator;

public class S2271MaximumWhiteTilesCoveredCarpet {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(o -> o[0]));

        int lo = 0, hi = 0;
        int res = 0, cur = 0;

        while (lo < tiles.length) {
            int start = tiles[lo][0], end = start+carpetLen;
            while (hi < tiles.length && tiles[hi][1] < end) {
                cur += tiles[hi][1]-tiles[hi][0]+1;
                hi++;
            }
            res = Math.max(res, cur);
            if (hi == tiles.length) {
                break;
            }
            // tiles[hi][1] >= end
            res = Math.max(res, cur + Math.max(end, tiles[hi][0])-tiles[hi][0]);
            cur -= tiles[lo][1]-tiles[lo][0]+1;
            lo++;
        }
        return res;
    }
}
