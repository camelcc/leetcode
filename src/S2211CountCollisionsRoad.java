public class S2211CountCollisionsRoad {
    public int countCollisions(String directions) {
        int res = 0, i = 0;
        while (i < directions.length() && directions.charAt(i) == 'L') {
            i++;
        }
        int cnt = 0;
        while (i < directions.length()) {
            char c = directions.charAt(i);
            if (c == 'L') {
                res += cnt+1;
                cnt = 0;
            } else if (c == 'R') {
                cnt++;
            } else if (c == 'S') {
                res += cnt;
                cnt = 0;
            }
            i++;
        }
        return res;
    }
}
