public class S0621TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char t : tasks) {
            counts[t - 'A']++;
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[max] < counts[i]) {
                max = i;
            }
        }
        int sameMax = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] == counts[max]) {
                sameMax++;
            }
        }

        return Math.max(tasks.length, (counts[max]-1)*(n+1)+sameMax);
    }
}
