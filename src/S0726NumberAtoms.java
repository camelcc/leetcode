import java.util.*;

public class S0726NumberAtoms {
    public String countOfAtoms(String formula) {
        Stack<HashMap<String, Integer>> stack = new Stack<>();
        HashMap<String, Integer> current = new HashMap<>();
        int pos = 0;
        while (pos < formula.length()) {
            char c = formula.charAt(pos);
            if (c == '(') {
                stack.push(current);
                current = new HashMap<>();
                pos++;
                continue;
            }

            if (c == ')') {
                assert !stack.isEmpty();
                HashMap<String, Integer> prev = stack.pop();
                pos++;
                String num = readNum(formula, pos);
                if (!num.isEmpty()) {
                    int v = Integer.valueOf(num);
                    for (String k : current.keySet()) {
                        current.put(k, current.get(k)*v);
                    }
                    pos = pos+num.length();
                }
                for (String k : current.keySet()) {
                    if (prev.containsKey(k)) {
                        prev.put(k, current.get(k)+prev.get(k));
                    } else {
                        prev.put(k, current.get(k));
                    }
                }
                current = prev;
                continue;
            }

            assert Character.isUpperCase(formula.charAt(pos));
            StringBuilder atom = new StringBuilder();
            atom.append(formula.charAt(pos));
            pos++;
            while (pos < formula.length() && Character.isLowerCase(formula.charAt(pos))) {
                atom.append(formula.charAt(pos));
                pos++;
            }
            String a = atom.toString();
            int cnt = 1;
            String num = readNum(formula, pos);
            if (!num.isEmpty()) {
                cnt = Integer.valueOf(num);
                pos = pos + num.length();
            }
            current.put(a, current.getOrDefault(a, 0) + cnt);
        }
        List<String> atoms = new ArrayList<>(current.keySet());
        Collections.sort(atoms);
        StringBuilder res = new StringBuilder();
        for (String a : atoms) {
            res.append(a);
            if (current.get(a) > 1) {
                res.append(String.valueOf(current.get(a)));
            }
        }
        return res.toString();
    }

    private String readNum(String formula, int pos) {
        StringBuilder sb = new StringBuilder();
        while (pos < formula.length() && Character.isDigit(formula.charAt(pos))) {
            sb.append(formula.charAt(pos));
            pos++;
        }
        return sb.toString();
    }
}
