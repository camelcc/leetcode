public class S0223RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = Math.abs(A-C)*Math.abs(B-D) + Math.abs(E-G)*Math.abs(F-H);

        if (Math.max(A, C) <= Math.min(E, G) ||
                Math.max(E, G) <= Math.min(A, C) ||
                Math.max(B, D) <= Math.min(F, H) ||
                Math.max(F, H) <= Math.min(B, D)) {
            return total;
        }

        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int bottom = Math.max(B, F);
        int top = Math.min(D, H);
        return total - (right - left) * (top - bottom);
    }
}
