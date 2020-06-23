import java.util.HashMap;

public class S1487MakingFileNamesUnique {
    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> bases = new HashMap<>();
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            if (!bases.containsKey(names[i])) {
                res[i] = names[i];
            } else {
                if (!bases.containsKey(names[i]+"(1)")) {
                    res[i] = names[i]+"(1)";
                    bases.put(names[i], 1);
                } else {
                    int sur = bases.get(names[i]) + 1;
                    while (bases.containsKey(names[i] + "(" + sur + ")")) {
                        sur++;
                    }
                    res[i] = names[i] + "(" + sur + ")";
                    bases.put(names[i], sur);
                }
            }
            bases.put(res[i], 0);
        }
        return res;
    }
}
