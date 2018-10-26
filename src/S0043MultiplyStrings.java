public class S0043MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] sum = new int[num1.length()+num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int v = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                sum[i+j] += v/10;
                sum[i+j+1] += v%10;
            }
        }
        int c = 0;
        for (int i = sum.length-1; i >= 0; i--) {
            int s = sum[i]+c;
            c = s/10;
            sum[i] = s%10;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] == 0 && res.length() == 0) {
                continue;
            }
            res.append(String.valueOf(sum[i]));
        }
        return res.toString();
    }
}
