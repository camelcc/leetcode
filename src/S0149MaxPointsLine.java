import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class S0149MaxPointsLine {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1]-o2[1];
                } else {
                    return o1[0]-o2[0];
                }
            }
        });
        int[] cnt = new int[points.length];
        cnt[0] = 1;
        int di = 0;
        int index = 1;
        while (index < points.length) {
            if (points[index][0] == points[di][0] && points[index][1] == points[di][1]) {
                cnt[di]++;
            } else {
                di++;
                points[di][0] = points[index][0];
                points[di][1] = points[index][1];
                cnt[di] = 1;
            }
            index++;
        }
        int len = di+1;

        int res = cnt[0];
        int groupId = 1;
        HashSet<Integer>[] groups = new HashSet[len];
        for (int i = 0; i < len; i++) {
            groups[i] = new HashSet<>();
        }

        for (int i = 0; i < len-1; i++) {
            HashSet<Integer> startGroup = groups[i];
            for (int j = i+1; j < len; j++) {
                HashSet<Integer> endGroup = groups[j];
                if (!Collections.disjoint(startGroup, endGroup)) {
                    continue;
                }

                int id = groupId++;
                startGroup.add(id);
                endGroup.add(id);
                for (int k = j+1; k < len; k++) {
                    if (!Collections.disjoint(startGroup, groups[k])) {
                        continue;
                    }
                    boolean oneline = ((long)(points[j][1]-points[i][1]))*(points[k][0]-points[i][0]) ==
                            ((long)(points[k][1]-points[i][1]))*(points[j][0]-points[i][0]);
                    if (oneline) {
                        groups[k].add(id);
                    }
                }

                int l = 0;
                for (int k = 0; k < len; k++) {
                    if (groups[k].contains(id)) {
                        l += cnt[k];
                    }
                }
                res = Math.max(res, l);
            }
        }
        return res;
    }
}
