public class S1163LastSubstringLexicographicalOrder {
    public String lastSubstring(String s) {
        int largestCharacter = s.charAt(0);
        boolean allCharsSame = true;
        for(char c : s.toCharArray()){
            if(c != largestCharacter)
                allCharsSame = false;
            largestCharacter = Math.max(largestCharacter, c);
        }
        if(allCharsSame)
            return s;
        String result = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == largestCharacter && s.substring(i).compareTo(result) > 0)
                result = s.substring(i);
        }
        return result;
    }
}
