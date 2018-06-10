public class S0405Convert2Hex {
    public String toHex(int num) {
        StringBuilder hex = new StringBuilder();
        while (num != 0) {
            int h = num & 0xf;
            char c = h >= 10 ? (char)('a' + (h-10)) : (char)('0' + h);
            hex.insert(0, c);
            num = num >> 4;
            if (num < 0) {
                num = num & 0x0fffffff;
            }
        }
        if (hex.toString().length() == 0) {
            return "0";
        }
        return hex.toString();
    }
}
