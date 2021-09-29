import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// https://leetcode.com/problems/the-score-of-students-solving-math-expression/discuss/1486306/PythonJava-Explanation-with-pictures-DP
public class S2019ScoreStudentsSolvingMathExpression {
    public int calculate(String s) {
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        char operator = '+';
        int num = 0;
        while (i < s.length()) {
            char ch = s.charAt(i++);
            if (ch >= '0' && ch <= '9') num = ch - '0';
            if (i >= s.length() || ch == '+' || ch == '*') {
                if (operator == '+') stack.push(num);
                else if (operator == '*') stack.push(stack.pop() * num);
                operator = ch;
                num = 0;
            }
        }
        return stack.stream().mapToInt(Integer::intValue).sum();
    }

    public int scoreOfStudents(String s, int[] answers) {
        int n = (int)(s.length() / 2 + 1);
        Set<Integer>[][] res = new Set[n][n];
        for (int i = 0; i < n; ++i){
            res[i][i] = new HashSet<>();
            res[i][i].add(s.charAt(2 * i) - '0');
        }
        for (int dif = 1; dif < n; ++dif){
            for (int start = 0; start < n - dif; ++start){
                int end = start + dif;
                res[start][end] = new HashSet<>();
                for (int i = start * 2 + 1; i < end * 2; i += 2){
                    if (s.charAt(i) - '+' == 0){
                        for (int a : res[start][(int)(i / 2)]){
                            for (int b : res[(int)(i / 2 + 1)][end]){
                                if (a + b <= 1000) res[start][end].add(a + b);
                            }
                        }
                    } else {
                        for (int a : res[start][(int)(i / 2)]){
                            for (int b : res[(int)(i / 2 + 1)][end]){
                                if (a * b <= 1000) res[start][end].add(a * b);
                            }
                        }
                    }
                }
            }
        }

        int correct = calculate(s), ans = 0;
        for (int a : answers){
            if (a == correct) ans += 5;
            else if (res[0][n - 1].contains(a)) ans += 2;
        }
        return ans;

    }
}
