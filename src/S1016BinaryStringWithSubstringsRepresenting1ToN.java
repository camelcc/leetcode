public class S1016BinaryStringWithSubstringsRepresenting1ToN {
    public boolean queryString(String S, int N) {
        for (int i = N/2; i <= N; i++) {
           if (!S.contains(binary(i))) {
               return false;
           }
        }
        return true;
    }

    private String binary(int i) {
        StringBuilder sb = new StringBuilder();
        while (i > 0) {
            sb.insert(0, i%2);
            i = i/2;
        }
        return sb.toString();
    }
}
