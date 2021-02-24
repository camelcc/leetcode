public class S1566DetectPatternLengthMRepeatedKMoreTimes {
    public boolean containsPattern(int[] arr, int m, int k) {
        if (k <= 1 && arr.length >= m) {
            return true;
        }
        if (arr.length < m*k) {
            return false;
        }
        for (int start = 0; start <= arr.length-m*k; start++) {
            if (arr.length-start < m*k) {
                return false;
            }
            boolean match = true;
            for (int i = 0; i < m; i++) {
                // arr[start+i], arr[start+i+m], ...arr[start+i+(k-1)*m]
                for (int t = 1; t < k; t++) {
                    if (arr[start+i] != arr[start+i+t*m]) {
                        match = false;
                        break;
                    }
                }
                if (!match) {
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }
}
