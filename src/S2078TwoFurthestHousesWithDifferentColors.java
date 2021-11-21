public class S2078TwoFurthestHousesWithDifferentColors {
    public int maxDistance(int[] colors) {
        boolean[] visited = new boolean[101];
        int p = colors.length-1;
        int res = 0;
        while (p > 0 && p > res) {
            if (visited[colors[p]]) {
                p--;
                continue;
            }
            visited[colors[p]] = true;
            int i = 0;
            while (i < p && colors[i] == colors[p]) {
                i++;
            }
            res = Math.max(res, p-i);
        }
        return res;
    }
}
