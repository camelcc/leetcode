public class S1903LargestOddNumberString {
    public String largestOddNumber(String num) {
        int p = num.length()-1;
        while (p >= 0 && (num.charAt(p)-'0')%2 == 0) {
            p--;
        }
        if (p < 0) {
            return "";
        }
        return num.substring(0, p+1);
    }
}
