public class S1678GoalParserInterpretation {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < command.length()) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
                i++;
            } else {
//                command.charAt(i) == '('
                if (command.charAt(i+1) == ')') {
                    sb.append('o');
                    i = i+2;
                } else {
//                    command.charAt(i) == 'a'
                    sb.append("al");
                    i = i+4;
                }
            }
        }
        return sb.toString();
    }
}
