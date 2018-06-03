public class S0038CountAndSay {
    public String countAndSay(int n) {
        if (n < 0) {
            return "";
        }
        if (n == 1) {
            return "1";
        }

        String str = countAndSay(n-1);
        StringBuilder res = new StringBuilder();
        char c = str.charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            } else {
                res.append(String.valueOf(count)).append(c);
                c = str.charAt(i);
                count = 1;
            }
        }
        res.append(String.valueOf(count)).append(c);
        return res.toString();
    }
}
