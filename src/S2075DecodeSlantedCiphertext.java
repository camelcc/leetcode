public class S2075DecodeSlantedCiphertext {
    public String decodeCiphertext(String encodedText, int rows) {
        int r = 0, c = 0, i = 0, w = encodedText.length()/rows;
        StringBuilder sb = new StringBuilder();
        while (i < encodedText.length()) {
            sb.append(encodedText.charAt(i));
            r++;
            c++;
            if (r == rows) {
                r = 0;
                c -= (rows-1);
            }
            i = r*w+c;
        }
        return sb.toString().stripTrailing();
    }
}
