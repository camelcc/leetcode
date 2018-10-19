public class S0824GoatLatin {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String word : words) {
            if (word.isEmpty() || word.equals(" ")) {
                continue;
            }
            sb.append(" ");
            i++;

            char first = word.charAt(0);
            if (first == 'a' ||
                    first == 'e' ||
                    first == 'i' ||
                    first == 'o' ||
                    first == 'u' ||
                    first == 'A' ||
                    first == 'E' ||
                    first == 'I' ||
                    first == 'O' ||
                    first == 'U') {
                sb.append(word);
            } else {
                sb.append(word.substring(1)).append(first);
            }
            sb.append("ma");
            for (int j = 0; j < i; j++) {
                sb.append("a");
            }
        }
        return sb.deleteCharAt(0).toString();
    }
}
