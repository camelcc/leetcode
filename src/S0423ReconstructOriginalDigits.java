import java.util.Stack;

public class S0423ReconstructOriginalDigits {
    String[] numbers = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"}

    public String originalDigits(String s) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }

        Stack<int[]> stack = new Stack<>();
        stack.push(chars);

        Stack<Integer> nums = new Stack<>();
        while (s.isEmpty()) {
            boolean valid = false;

            for (int i = 0; i < 10; i++) {
            }
        }
    }

    private boolean getNum(int[] chars, int num) {
        for (char c : numbers[num].toCharArray()) {
            chars[c-'a']--;
            if (chars[c-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
