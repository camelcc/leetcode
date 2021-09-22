public class S2011FinalValueVariableAfterPerformingOperations {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String op : operations) {
            if (op.equals("++X") || op.equals("X++")) {
                res++;
            } else if (op.equals("--X") || op.equals("X--")) {
                res--;
            }
        }
        return res;
    }
}
