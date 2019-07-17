import java.util.Arrays;

public class S1024VideoStitching {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (int[] o1, int[] o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0]-o2[0];
            }
            return o1[1]-o2[1];
        });
        if (clips[clips.length-1][1] < T) {
            return -1;
        }
        return stitching(clips, 0, 0, 0, T);
    }

    private int stitching(int[][] clips, int end, int pos, int cuts, int T) {
        if (end >= T) {
            return cuts;
        }
        if (pos >= clips.length) {
            return -1;
        }
        int res = -1;
        int nextEnd = end, nextPos = pos;
        for (int p = pos; p < clips.length && clips[p][0] <= end; p++) {
            if (clips[p][1] <= nextEnd) {
                continue;
            }
            if (clips[p][1] > nextEnd) {
                nextEnd = clips[p][1];
                nextPos = p;
            }
        }
        if (nextEnd == end) {
            return -1;
        }
        return stitching(clips, nextEnd, nextPos, cuts+1, T);
    }
}
