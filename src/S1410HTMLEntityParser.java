public class S1410HTMLEntityParser {
    public String entityParser(String text) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            char c = text.charAt(i);
            if (c != '&') {
                sb.append(c);
                i++;
                continue;
            }

            // &
            int e = text.indexOf(';', i);
            if (e < 0) {
                sb.append(c);
                i++;
                continue;
            }

            // &...;
            String symbol = text.substring(i+1, e);
            if (symbol.equals("quot")) {
                sb.append('"');
                i = e+1;
            } else if (symbol.equals("apos")) {
                sb.append("'");
                i = e+1;
            } else if (symbol.equals("amp")) {
                sb.append("&");
                i = e+1;
            } else if (symbol.equals("gt")) {
                sb.append(">");
                i = e+1;
            } else if (symbol.equals("lt")) {
                sb.append("<");
                i = e+1;
            } else if (symbol.equals("frasl")) {
                sb.append("/");
                i = e+1;
            } else {
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }
}
