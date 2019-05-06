public class S0273IntegerEnglishWords {
    public String numberToWords(int num) {
        String[] digits = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] tens = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] hundrends = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        if (num >= 0 && num <= 9) {
            return digits[num];
        }
        // num >= 10
        if (num >= 10 && num <= 19) {
            return tens[num-10];
        }
        // num >= 20
        if (num >= 20 && num < 100) {
            String res = hundrends[num/10-2];
            if (num%10 != 0) {
                res += " " + digits[num%10];
            }
            return res;
        }
        if (num >= 100 && num < 1000) {
            String res = digits[num/100] + " Hundred";
            if (num%100 != 0) {
                res += " " + numberToWords(num%100);
            }
            return res;
        }
        if (num >= 1000 && num < 1000000) {
            String res = numberToWords(num/1000) + " Thousand";
            if (num%1000 != 0) {
                res += " " + numberToWords(num%1000);
            }
            return res;
        }
        if (num >= 1000000 && num < 1000000000) {
            String res = numberToWords(num/1000000) + " Million";
            if (num%1000000 != 0) {
                res += " " + numberToWords(num%1000000);
            }
            return res;
        }
        String res = numberToWords(num/1000000000) + " Billion";
        if (num%1000000000 != 0) {
            res += " " + numberToWords(num%1000000000);
        }
        return res;
    }
}
