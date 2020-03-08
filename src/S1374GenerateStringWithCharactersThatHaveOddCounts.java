public class S1374GenerateStringWithCharactersThatHaveOddCounts {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n%2 == 0) {
            int ca = n/2, cb = n/2;
            if (ca%2 == 0) {
                ca--;
                cb++;
            }
            for (int i = 0; i < ca; i++) {
                sb.append('a');
            }
            for (int i = 0; i < cb; i++) {
                sb.append('b');
            }
        } else { // n%2 == 1
            for (int i = 0; i < n; i++) {
                sb.append('a');
            }
        }
        return sb.toString();
    }
}
