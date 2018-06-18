public class S0504Base7 {
    public String convertToBase7(int num) {
        if (num < 0) {
            return "-" + convertToBase7(-num);
        }

        StringBuilder res = new StringBuilder();
        while (num >= 7) {
            res.insert(0, String.valueOf(num%7));
            num = num/7;
        }
        res.insert(0, String.valueOf(num));
        return res.toString();
    }
}
