import java.util.*;

public class S1520MaximumNumberNonOverlappingSubstrings {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[][] segs = new int[26][2];
        for (int i = 0; i < 26; i++) {
            segs[i] = new int[]{n, -1};
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            segs[c-'a'][0] = Math.min(segs[c-'a'][0], i);
            segs[c-'a'][1] = Math.max(segs[c-'a'][1], i);
        }
        List<int[]> map = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (segs[i][0] >= n) {
                continue;
            }

            boolean valid = true;
            int l = segs[i][0], r = segs[i][1];
            for (int p = l+1; p < r; p++) {
                int t = s.charAt(p)-'a';
                if (segs[t][0] < l) {
                    valid = false;
                    break;
                }
                r = Math.max(r, segs[t][1]);
            }
            if (valid) {
                map.add(new int[]{l, r});
            }
        }
        map.sort(Comparator.comparingInt(o -> o[1]-o[0]+1));

        boolean[] used = new boolean[map.size()];
        List<int[]> max = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            max.add(map.get(i));
            int l = map.get(i)[0], r = map.get(i)[1];
            for (int j = i+1; j < map.size(); j++) {
                if (used[j]) {
                    continue;
                }
                if (l > map.get(j)[1] || r < map.get(j)[0]) {
                    continue;
                }
                used[j] = true;
            }
        }

        List<String> res = new ArrayList<>();
        for (int[] m : max) {
            res.add(s.substring(m[0], m[1]+1));
        }
        return res;
    }
}
