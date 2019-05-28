import java.util.*;

public class S0770BasicCalculatorIV {
    private class Item implements Comparable<Item> {
        int coef;
        List<String> vars;

        public Item(int coef) {
            this.coef = coef;
            vars = new ArrayList<>();
        }

        public Item(String var) {
            coef = 1;
            vars = new ArrayList<>();
            vars.add(var);
        }

        public boolean isZero() {
            return coef == 0;
        }

        @Override
        public String toString() {
            return String.valueOf(coef)+varString();
        }

        private String varString() {
            Collections.sort(vars);
            StringBuilder sb = new StringBuilder();
            for (String s : vars) {
                sb.append('*');
                sb.append(s);
            }
            return sb.toString();
        }

        @Override
        public boolean equals(Object obj) {
            return varString().equals(((Item)obj).varString());
        }

        @Override
        public int compareTo(Item o) {
            if (vars.size() != o.vars.size()) {
                return o.vars.size() - vars.size();
            }
            return varString().compareTo(o.varString());
        }

        public Item mul(Item t) {
            Item res = new Item(coef);
            res.vars.addAll(vars);
            res.coef *= t.coef;
            res.vars.addAll(t.vars);
            return res;
        }
    }

    private class Expression {
        List<Item> items;

        public Expression() {
            items = new ArrayList<>();
        }

        public Expression(int coef) {
            items = new ArrayList<>();
            items.add(new Item(coef));
        }

        public Expression(String item) {
            items = new ArrayList<>();
            items.add(new Item(item));
        }

        public Expression(Item item) {
            items = new ArrayList<>();
            items.add(item);
        }

        public Expression add(Expression expr) {
            for (Item exprItem : expr.items) {
                int i = items.indexOf(exprItem);
                if (i == -1) {
                    if (exprItem.coef != 0) {
                        items.add(exprItem);
                    }
                } else {
                    items.get(i).coef += exprItem.coef;
                    if (items.get(i).coef == 0) {
                        items.remove(i);
                    }
                }
            }
            return this;
        }

        public Expression mul(Expression expr) {
            Expression res = new Expression();
            for (Item item : items) {
                for (Item exprItem : expr.items) {
                    res.add(new Expression(item.mul(exprItem)));
                }
            }
            return res;
        }
    }

    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < evalints.length; i++) {
            map.put(evalvars[i], evalints[i]);
        }

        Expression out = new Expression();
        calculate(expression, 0, out, map);
        Collections.sort(out.items);
        List<String> res = new ArrayList<>();
        for (Item item : out.items) {
            if (!item.isZero()) {
                res.add(item.toString());
            }
        }
        return res;
    }

    private int calculate(String expression, int startIndex, Expression out, HashMap<String, Integer> map) {
        Stack<Expression> stack = new Stack<>();
        stack.push(new Expression(0));
        int lastOp = 0; // 0 +, 1 -, 2 *
        int i = startIndex;
        while (i < expression.length()) {
            char c = expression.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }

            if (c == '(') {
                Expression t = new Expression(0);
                i = calculate(expression, i+1, t, map);
                if (lastOp == 0) { // +
                    stack.push(t);
                } else if (lastOp == 1) { // -
                    stack.push(t.mul(new Expression(-1)));
                } else if (lastOp == 2) { // *
                    stack.push(stack.pop().mul(t));
                }
            } else if (c == ')') {
                break;
            } else if (c == '+') {
                lastOp = 0;
            } else if (c == '-') {
                lastOp = 1;
            } else if (c == '*') {
                lastOp = 2;
            } else {
                int j = i+1;
                while (j < expression.length() && expression.charAt(j) != ' ' && expression.charAt(j) != ')') {
                    j++;
                }

                String item = expression.substring(i, j);
                assert item.length() > 0;
                Expression cur;
                if (Character.isDigit(item.charAt(0))) {
                    cur = new Expression(Integer.valueOf(item));
                } else {
                    if (map.containsKey(item)) {
                        cur = new Expression(Integer.valueOf(map.get(item)));
                    } else {
                        cur = new Expression(item);
                    }
                }

                if (lastOp == 0) { // +
                    stack.push(cur);
                } else if (lastOp == 1) { // -
                    stack.push(cur.mul(new Expression(-1)));
                } else if (lastOp == 2) { // *
                    stack.push(stack.pop().mul(cur));
                }

                i = j-1;
            }
            i++;
        }

        while (!stack.isEmpty()) {
            out.add(stack.pop());
        }
        return i;
    }
}
