import edu.princeton.cs.algs4.Stack;

public class S2000ReversePrefixWord {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == ch) {
                sb.append(c);
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(word.substring(i+1));
                return sb.toString();
            } else {
                stack.push(c);
            }
        }
        return word;
    }
}
