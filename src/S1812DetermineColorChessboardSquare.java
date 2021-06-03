public class S1812DetermineColorChessboardSquare {
    public boolean squareIsWhite(String coordinates) {
        int c = coordinates.charAt(0)-'a', r = coordinates.charAt(1)-'0';
        return (c%2 == 1 && r%2 == 1) || (c%2 == 0 && r%2 == 0);
    }
}
