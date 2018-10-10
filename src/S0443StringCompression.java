public class S0443StringCompression {
    public int compress(char[] chars) {
        int len = 0;
        char current = chars[0];
        int count = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == current) {
                count++;
                continue;
            }
            chars[len++] = current;
            current = chars[i];
            if (count == 1) {
                continue;
            }
            String num = String.valueOf(count);
            for (char n : num.toCharArray()) {
                chars[len++] = n;
            }
            count = 1;
        }
        chars[len++] = current;
        if (count > 1) {
            String num = String.valueOf(count);
            for (char n : num.toCharArray()) {
                chars[len++] = n;
            }
        }
        return len;
    }
}
