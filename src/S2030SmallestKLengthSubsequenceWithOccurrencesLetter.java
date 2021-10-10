import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/smallest-k-length-subsequence-with-occurrences-of-a-letter/discuss/1505481/JAVA-Monotonic-Stack-Solution
public class S2030SmallestKLengthSubsequenceWithOccurrencesLetter {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        Deque<Character> stack = new ArrayDeque<>();
        int count = 0; // count how many `letter` in the stack
        int left = s.length();
        int letterCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) letterCount++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Make sure ther are still have enough space left for `repetition` letters
            while (!stack.isEmpty() && (c < stack.peek() || k - stack.size() < repetition - count)) {
                // Make sure there are still have enough letters left to compose `k` letters.
                if (left + stack.size() <= k) break;
                // Make sure there are at least `repetition` letters left
                if (stack.peek() == letter && letterCount <= repetition) break;

                if (stack.pop() == letter) {
                    count--;
                    letterCount--;
                }
            }
            stack.push(c);
            if (c == letter) count++;
            left--;
        }

        while (stack.size() > k) stack.pop();

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }
}
