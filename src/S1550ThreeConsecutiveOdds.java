public class S1550ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        int c = 0;
        for (int a : arr) {
            if (a%2 == 1) {
                c++;
                if (c >= 3) {
                    return true;
                }
            } else {
                c = 0;
            }
        }
        return false;
    }
}
