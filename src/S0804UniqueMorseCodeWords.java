import java.util.HashSet;

public class S0804UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> morse = new HashSet<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(codes[c-'a']);
            }
            String code = sb.toString();
            morse.add(code);
        }
        return morse.size();
    }
}
