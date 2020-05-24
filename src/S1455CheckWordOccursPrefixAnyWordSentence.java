public class S1455CheckWordOccursPrefixAnyWordSentence {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int i = 0;
        while (i < words.length) {
            if (words[i].startsWith(searchWord)) {
                break;
            }
            i++;
        }
        if (i == words.length) {
            return -1;
        } else {
            return i+1;
        }
    }
}
