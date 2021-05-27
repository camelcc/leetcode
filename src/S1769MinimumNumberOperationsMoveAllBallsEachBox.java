public class S1769MinimumNumberOperationsMoveAllBallsEachBox {
    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            char c = boxes.charAt(i);
            if (c == '0') {
                continue;
            }
            // c == '1'
            for (int j = 0; j < boxes.length(); j++) {
                res[j] += Math.abs(j-i);
            }
        }
        return res;
    }
}
