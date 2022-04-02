public class S2222NumberWaysSelectBuildings {
    public long numberOfWays(String s) {
        long ones = 0, zeros = 0, onezeros = 0, zeroones = 0, res = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '0') {
                res += onezeros;
                zeroones += ones;
                zeros ++;
            } else if (c == '1') {
                res += zeroones;
                onezeros += zeros;
                ones++;
            }
        }
        return res;
    }
}
