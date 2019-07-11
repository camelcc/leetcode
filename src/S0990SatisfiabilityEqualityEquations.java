public class S0990SatisfiabilityEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        int[] var = new int[26];
        for (int i = 0; i < 26; i++) {
            var[i] = i;
        }
        for (Boolean first : new Boolean[]{true, false}) {
            for (String equation : equations) {
                char a = equation.charAt(0);
                char b = equation.charAt(3);
                int ra = var[a - 'a'];
                while (var[ra] != ra) {
                    ra = var[ra];
                }
                int rb = var[b - 'a'];
                while (var[rb] != rb) {
                    rb = var[rb];
                }
                if (first && equation.charAt(1) == '=') { // ==
                    if (ra != rb) {
                        var[Math.max(ra, rb)] = Math.min(ra, rb);
                    }
                } else if (!first && equation.charAt(1) == '!') { // !=
                    if (ra == rb) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
