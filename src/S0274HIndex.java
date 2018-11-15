import java.util.Arrays;

public class S0274HIndex {
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length-i;
            if (citations[i] >= h && (i == 0 || citations[i-1] <= h)) {
                return h;
            }
        }
        return 0;
    }
}
