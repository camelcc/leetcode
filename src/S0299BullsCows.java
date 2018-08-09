import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class S0299BullsCows {
    //TODO: one pass solution
    public String getHint(String secret, String guess) {
        List<Character> secretArray = new ArrayList<>();
        List<Character> guessArray = new ArrayList<>();
        for (char c : secret.toCharArray()) {
            secretArray.add(c);
        }
        for (char c : guess.toCharArray()) {
            guessArray.add(c);
        }

        int bulls = 0;
        int cows = 0;

        Iterator<Character> secretIter = secretArray.iterator();
        Iterator<Character> guessIter = guessArray.iterator();
        while (secretIter.hasNext() && guessIter.hasNext()) {
            if (secretIter.next() == guessIter.next()) {
                secretIter.remove();
                guessIter.remove();
                bulls++;
            }
        }

        for (char c : guessArray) {
            if (secretArray.contains(c)) {
                secretArray.remove((Character)c);
                cows++;
            }
        }

        return bulls + "A" + cows + "B";
    }
}
