public class S1629SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char res = '\0';
        int duration = 0;
        int t = 0;
        for (int i = 0; i < releaseTimes.length; i++) {
            int d = releaseTimes[i] - t;
            t = releaseTimes[i];
            char c = keysPressed.charAt(i);
            if (d > duration) {
                res = c;
                duration = d;
            } else if (d == duration) {
                if (c > res) {
                    res = c;
                }
            }
        }
        return res;
    }
}
