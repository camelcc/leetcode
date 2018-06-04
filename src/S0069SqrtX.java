public class S0069SqrtX {
    public int mySqrt(int x) {
        float torrance = 0.00001f;
        float guess = 1;
        float improve = 1;
        do {
            guess = improve;
            improve =(guess + 1.0f*x/guess)/2;
        } while (Math.abs(guess - improve) > torrance);
        long g =(long)Math.ceil(guess);
        while (g*g > (long)x) {
            g--;
        }
        return (int)g;
    }
}
