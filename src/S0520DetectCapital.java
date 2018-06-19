public class S0520DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) {
            return true;
        }

        char firstChar = word.charAt(0);
        boolean isFirstCap = firstChar >= 'A' && firstChar <= 'Z';
        char secondChar = word.charAt(1);
        boolean isSecondCap = secondChar >= 'A' && secondChar <= 'Z';
        if (!isFirstCap && isSecondCap) {
            return false;
        }
        boolean shouldAllLower = !isSecondCap;
        for (int i = 2; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean isCap = c >= 'A' && c <= 'Z';
            if (shouldAllLower == isCap) {
                return false;
            }
        }
        return true;
    }
}
