public class S1880CheckWordEqualsSummationTwoWords {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int first = 0, second = 0, target = 0;
        for (char c  : firstWord.toCharArray()) {
            first = first*10 + (c-'a');
        }
        for (char c : secondWord.toCharArray()) {
            second = second*10 + (c-'a');
        }
        for (char c : targetWord.toCharArray()) {
            target = target*10 + (c-'a');
        }
        return (long)target == (long)(first)+second;
    }
}
