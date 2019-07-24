public class S1108DefangingIPAddress {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
