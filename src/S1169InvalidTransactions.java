import java.util.*;

public class S1169InvalidTransactions {
    public List<String> invalidTransactions(String[] transactions) {
        String[][] trans = new String[transactions.length][5];
        for (int i = 0; i < transactions.length; i++) {
            String[] t = transactions[i].split(",");
            for (int j = 0; j < 4; j++) {
                trans[i][j] = t[j];
            }
            trans[i][4] = transactions[i];
        }

        Arrays.sort(trans, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (!o1[0].equals(o2[0])) {
                    return o1[0].compareTo(o2[0]);
                }
                if (!o1[1].equals(o2[1])) {
                    return Integer.parseInt(o1[1])-Integer.parseInt(o2[1]);
                }
                return o1[3].compareTo(o2[3]);
            }
        });
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i < trans.length; i++) {
            if (Integer.parseInt(trans[i][2]) > 1000) {
                res.add(trans[i][4]);
            }
            int j = i-1;
            while (j >= 0 && trans[j][0].equals(trans[i][0]) &&
                    Integer.parseInt(trans[j][1]) >= Integer.parseInt(trans[i][1])-60) {
                if (!trans[j][3].equals(trans[i][3])) {
                    res.add(trans[i][4]);
                    res.add(trans[j][4]);
                }
                j--;
            }
        }
        return new ArrayList<>(res);
    }
}
