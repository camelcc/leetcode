public class S0984StringWithoutAAABBB {
    public String strWithout3a3b(int A, int B) {
        assert A > 0 && B > 0;
        StringBuilder sb = new StringBuilder();
        if (A == B) {
            for (int i = 0; i < A; i++) {
                sb.append("ab");
            }
        } else if (A < B) {
            while (A < B && A > 0) {
                sb.append("bba");
                A -= 1;
                B -= 2;
            }
            if (A == 0) {
                assert B < 3;
                if (B == 2) {
                    sb.append("bb");
                } else if (B == 1) {
                    sb.append('b');
                }
            } else {
                assert A == B;
                for (int i = 0; i < A; i++) {
                    sb.append("ba");
                }
            }
        } else if (A > B) {
            while (A > B && B > 0) {
                sb.append("aab");
                A -= 2;
                B -= 1;
            }
            if (B == 0) {
                assert A < 3;
                if (A == 2) {
                    sb.append("aa");
                } else if (A == 1) {
                    sb.append("a");
                }
            } else {
                assert A == B;
                for (int i = 0; i < A; i++) {
                    sb.append("ab");
                }
            }
        }
        return sb.toString();
    }
}
