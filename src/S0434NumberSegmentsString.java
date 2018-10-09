public class S0434NumberSegmentsString {
    public int countSegments(String s) {
        int count = 0;
        for (String str : s.split(" ")) {
            if (!str.isEmpty() && !str.equals(" ")) {
                count++;
            }
        }
        return count;
    }
}
