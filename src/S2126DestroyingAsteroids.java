import java.util.Arrays;

public class S2126DestroyingAsteroids {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int[] cnt = new int[100001];
        int min = asteroids[0], max = asteroids[0];
        for (int a : asteroids) {
            cnt[a]++;
            min = Math.min(min, a);
            max = Math.max(max, a);
        }
        long m = mass;
        for (int i = min; i <= max; i++) {
            if (m < i) {
                return false;
            }
            if (m >= max) {
                return true;
            }
            m += cnt[i]*i;
        }
        return true;
    }
}
