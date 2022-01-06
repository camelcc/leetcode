public class S2125NumberLaserBeamsBank {
    public int numberOfBeams(String[] bank) {
        int res = 0, pre = 0;
        for (String floor : bank) {
            int cnt = 0;
            for (char c : floor.toCharArray()) {
                if (c == '1') {
                    cnt++;
                }
            }
            if (cnt != 0) {
                res += pre * cnt;
                pre = cnt;
            }
        }
        return res;
    }
}
