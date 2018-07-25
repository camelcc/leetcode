public class S0165CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            if (i >= v1.length) {
                int v2n = Integer.valueOf(v2[i]);
                if (v2n != 0) {
                    return -1;
                }
                continue;
            }
            if (i >= v2.length) {
                int v1n = Integer.valueOf(v1[i]);
                if (v1n != 0) {
                    return 1;
                }
                continue;
            }

            int v1n = Integer.valueOf(v1[i]);
            int v2n = Integer.valueOf(v2[i]);
            if (v1n != v2n) {
                return v1n > v2n ? 1 : -1;
            }
        }
        return 0;
    }
}
