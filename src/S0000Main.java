import edu.princeton.cs.algs4.StdOut;

public class S0000Main {
    public static void main(String[] args) {
        S0591TagValidator validator = new S0591TagValidator();
        StdOut.println(validator.isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
    }
}
