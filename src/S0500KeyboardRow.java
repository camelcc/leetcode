import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S0500KeyboardRow {
    public String[] findWords(String[] words) {
        HashMap<Character, Integer> keyboard = new HashMap<>();
        keyboard.put('0', 1);
        keyboard.put('1', 1);
        keyboard.put('2', 1);
        keyboard.put('3', 1);
        keyboard.put('4', 1);
        keyboard.put('5', 1);
        keyboard.put('6', 1);
        keyboard.put('7', 1);
        keyboard.put('8', 1);
        keyboard.put('9', 1);
        keyboard.put('q', 2);
        keyboard.put('Q', 2);
        keyboard.put('w', 2);
        keyboard.put('W', 2);
        keyboard.put('e', 2);
        keyboard.put('E', 2);
        keyboard.put('R', 2);
        keyboard.put('r', 2);
        keyboard.put('t', 2);
        keyboard.put('T', 2);
        keyboard.put('y', 2);
        keyboard.put('Y', 2);
        keyboard.put('u', 2);
        keyboard.put('U', 2);
        keyboard.put('i', 2);
        keyboard.put('I', 2);
        keyboard.put('o', 2);
        keyboard.put('O', 2);
        keyboard.put('p', 2);
        keyboard.put('P', 2);
        keyboard.put('a', 3);
        keyboard.put('A', 3);
        keyboard.put('s', 3);
        keyboard.put('S', 3);
        keyboard.put('d', 3);
        keyboard.put('D', 3);
        keyboard.put('f', 3);
        keyboard.put('F', 3);
        keyboard.put('g', 3);
        keyboard.put('G', 3);
        keyboard.put('h', 3);
        keyboard.put('H', 3);
        keyboard.put('j', 3);
        keyboard.put('J', 3);
        keyboard.put('k', 3);
        keyboard.put('K', 3);
        keyboard.put('l', 3);
        keyboard.put('L', 3);
        keyboard.put('z', 4);
        keyboard.put('Z', 4);
        keyboard.put('x', 4);
        keyboard.put('X', 4);
        keyboard.put('c', 4);
        keyboard.put('C', 4);
        keyboard.put('v', 4);
        keyboard.put('V', 4);
        keyboard.put('b', 4);
        keyboard.put('B', 4);
        keyboard.put('n', 4);
        keyboard.put('N', 4);
        keyboard.put('m', 4);
        keyboard.put('M', 4);

        List<String> oneRow = new ArrayList<>();
        for (String word : words) {
            if (word.isEmpty()) {
                oneRow.add(word);
                continue;
            }
            int row = keyboard.get(word.charAt(0));
            boolean match = true;
            for (int i = 1; i < word.length(); i++) {
                if (keyboard.get(word.charAt(i)) != row) {
                    match = false;
                    break;
                }
            }
            if (match) {
                oneRow.add(word);
            }
        }
        return oneRow.toArray(new String[oneRow.size()]);
    }
}
