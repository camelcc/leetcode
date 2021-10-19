public class S2042CheckNumbersAreAscendingSentence {
    public boolean areNumbersAscending(String s) {
        int current = 0;
        String[] seg = s.split(" ");
        for (int i = 0; i < seg.length; i++) {
            if (Character.isDigit(seg[i].charAt(0))) {
                int v = Integer.valueOf(seg[i]);
                if (v <= current) {
                    return false;
                }
                current = v;
            }
        }
        return true;
    }
}
