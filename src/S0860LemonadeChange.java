public class S0860LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int b : bills) {
            if (b == 5) {
                five++;
            } else if (b == 10) {
                ten++;
                if (five > 0) {
                    five--;
                } else {
                    return false;
                }
            } else if (b == 20) {
                if (ten > 0) {
                    ten--;
                    if (five > 0) {
                        five--;
                    } else {
                        return false;
                    }
                } else {
                    if (five < 3) {
                        return false;
                    } else {
                        five -= 3;
                    }
                }
            }
        }
        return true;
    }
}
