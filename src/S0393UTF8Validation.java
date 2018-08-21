public class S0393UTF8Validation {
    public boolean validUtf8(int[] data) {
        if (data.length == 0) {
            return true;
        }

        return valid(data, 0);
    }

    private boolean valid(int[] data, int start) {
        assert data.length > start;
        int first = data[start];
        if ((first & 0x80) == 0) { // 1 byte
            if (start + 1 == data.length) {
                return true;
            } else {
                return valid(data, start+1);
            }
        } else if ((first & 0xE0) == 0xC0) { // 2 byte
            if (data.length - start < 2) {
                return false;
            }
            if ((data[start+1] & 0xC0) != 0x80) {
                return false;
            }
            if (start + 2 == data.length) {
                return true;
            }
            return valid(data, start+2);
        } else if ((first & 0xF0) == 0xE0) { // 3 bytes
            if (data.length - start < 3) {
                return false;
            }
            if ((data[start + 1] & 0xC0) != 0x80) {
                return false;
            }
            if ((data[start + 2] & 0xC0) != 0x80) {
                return false;
            }
            if (start + 3 == data.length) {
                return true;
            }
            return valid(data, start+3);
        } else if ((first & 0xF8) == 0xF0) { // 4 bytes
            if (data.length - start < 4) {
                return false;
            }
            if ((data[start + 1] & 0xC0) != 0x80) {
                return false;
            }
            if ((data[start + 2] & 0xC0) != 0x80) {
                return false;
            }
            if ((data[start + 3] & 0xC0) != 0x80) {
                return false;
            }
            if (start + 4 == data.length) {
                return true;
            }
            return valid(data, start+4);
        } else {
            return false;
        }
    }
}
