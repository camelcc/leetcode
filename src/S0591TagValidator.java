public class S0591TagValidator {
    public boolean isValid(String code) {
        int i = consumeTagHead(code, 0);
        if (i == -1) {
            return false;
        }
        String start = code.substring(1, i-1);
        i = consumeContent(code, i);
        if (i == -1) {
            return false;
        }
        i = consumeTagEnd(code, start, i);
        if (i == -1 || i != code.length()) {
            return false;
        }
        return true;
    }

    private int consumeContent(String code, int start) {
        if (start == code.length()) {
            return start;
        }

        int i;
        if (predictCData(code, start)) {
            i = consumeCData(code, start);
            if (i == -1) {
                return -1;
            }
            if (i == code.length()) {
                return i;
            }
            return consumeContent(code, i);
        } else if (predictCloseTag(code, start)) {
            return start;
        } else if (predictOpenTag(code, start)) {
            i = consumeTagHead(code, start);
            if (i == -1 || i == code.length()) {
                return -1;
            }
            String begin = code.substring(start+1, i-1);
            i = consumeContent(code, i);
            if (i == -1 || i == code.length()) {
                return -1;
            }
            i = consumeTagEnd(code, begin, i);
            if (i == -1) {
                return -1;
            }
            if (i == code.length()) {
                return i;
            }
            return consumeContent(code, i);
        } else {
            if (start == code.length()) {
                return start;
            }
            return consumeContent(code, start+1);
        }
    }

    private boolean predictOpenTag(String code, int start) {
        return code.charAt(start) == '<' && start+1 < code.length() && code.charAt(start+1) != '/';
    }

    private int consumeTagHead(String code, int start) {
        if (!predictOpenTag(code, start)) {
            return -1;
        }
        int i = code.indexOf('>', start);
        if (i == -1) {
            return -1;
        }
        int t = code.indexOf('<', start+1);
        if (t != -1 && t < i) {
            return -1;
        }
        String tag = code.substring(start+1, i);
        if (tag.length() < 1 || tag.length() > 9) {
            return -1;
        }
        for (char c : tag.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                continue;
            } else {
                return -1;
            }
        }
        return i+1;
    }

    private boolean predictCloseTag(String code, int start) {
        return code.startsWith("</", start);
    }

    private int consumeTagEnd(String code, String begin, int start) {
        if (!predictCloseTag(code, start)) {
            return -1;
        }
        int i = code.indexOf('>', start);
        if (i == -1) {
            return -1;
        }
        int t = code.indexOf('<', start+1);
        if (t != -1 && t < i) {
            return -1;
        }
        String tag = code.substring(start+2, i);
        if (tag.length() < 1 || tag.length() > 9) {
            return -1;
        }
        for (char c : tag.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                continue;
            } else {
                return -1;
            }
        }
        return tag.equals(begin) ? i+1 : -1;
    }

    private boolean predictCData(String code, int start) {
        return code.startsWith("<![CDATA[", start);
    }

    private int consumeCData(String code, int start) {
        if (!predictCData(code, start)) {
            return -1;
        }
        int i = code.indexOf("]]>", start);
        if (i == -1) {
            return -1;
        }
        return i+3;
    }
}
