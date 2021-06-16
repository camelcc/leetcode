import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.Collectors;

// https://leetcode.com/problems/minimum-cost-to-change-the-final-value-of-expression/discuss/1267531/Java-Clear-OOD-parser-%2B-DP-O(n)
public class S1896MinimumCostChangeFinalValueExpression {
    class Solution {
        public int minOperationsToFlip(String expression) {
            var tokens = Arrays.stream(expression.split("(?<=.)")).collect(Collectors.toCollection(ArrayDeque::new));
            Expr root = readE(tokens);
            // The cost of changing to original value must be 0, and the other one is what we want
            return Math.max(root.calcMinCost(0), root.calcMinCost(1));
        }

        private Expr readE(Queue<String> tokens) {
            Expr expr = readT(tokens);
            while (!tokens.isEmpty() && !tokens.peek().equals(")")) {
                expr = Op.valueOf(tokens.poll(), expr, readT(tokens));
            }
            return expr;
        }

        private Expr readT(Queue<String> tokens) {
            if (tokens.peek().equals("(")) {
                tokens.poll();
                Expr expr = readE(tokens);
                tokens.poll();
                return expr;
            } else {
                return new Val(tokens.poll().charAt(0) - '0');
            }
        }
    }

    abstract static class Expr {
        Expr left, right;

        abstract int calcMinCost(int target);
    }

    static class Val extends Expr {
        int val;

        Val(int val) {
            this.val = val;
        }

        @Override int calcMinCost(int target) {
            return val == target ? 0 : 1;
        }
    }

    abstract static class Op extends Expr {
        int[] minCost;

        Op(Expr left, Expr right) {
            this.left = left;
            this.right = right;
            this.minCost = new int[] {-1, -1};
        }

        static Op valueOf(String op, Expr left, Expr right) {
            if (op.equals("&")) {
                return new And(left, right);
            } else if (op.equals("|")) {
                return new Or(left, right);
            }
            return null;
        }
    }

    static class And extends Op {
        And(Expr left, Expr right) {
            super(left, right);
        }

        @Override int calcMinCost(int target) {
            if (minCost[target] < 0) {
                int leftCost = left.calcMinCost(target);
                int rightCost = right.calcMinCost(target);
                minCost[target] = target == 1
                        ? Math.min(leftCost + rightCost, 1 + Math.min(leftCost, rightCost))
                        : Math.min(leftCost, rightCost);
            }
            return minCost[target];
        }
    }

    static class Or extends Op {
        Or(Expr left, Expr right) {
            super(left, right);
        }

        @Override int calcMinCost(int target) {
            if (minCost[target] < 0) {
                int leftCost = left.calcMinCost(target);
                int rightCost = right.calcMinCost(target);
                minCost[target] = target == 0
                        ? Math.min(leftCost + rightCost, 1 + Math.min(leftCost, rightCost))
                        : Math.min(leftCost, rightCost);
            }
            return minCost[target];
        }
    }
}
