import java.util.Stack;

public class S0394DecodeString {
    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int num = 0;
        boolean inNumber = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                if (!inNumber) {
                    stringStack.add(sb.toString());
                    sb = new StringBuilder();
                    num = 0;
                }
                inNumber = true;
                num = num * 10 + c - '0';
            } else if (c == '[') {
                inNumber = false;
                numberStack.add(num);
                num = 0;
            } else if (c == ']') {
                inNumber = false;
                StringBuilder t = new StringBuilder(stringStack.pop());
                String tmp = sb.toString();
                int count = numberStack.pop();
                for (int j = 0; j < count; j++) {
                    t.append(tmp);
                }
                sb = t;
            } else {
                inNumber = false;
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
