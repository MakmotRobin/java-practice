package io.github.makmotrobin.practice.phone;

/** Defangs an IPv4 address by wrapping every dot in brackets. */
public final class DefangIpAddress {

    private DefangIpAddress() {
    }

    /**
     * @param address an IPv4 address such as {@code 192.168.1.1}
     * @return the same address with every {@code .} replaced by {@code [.]}
     */
    public static String defang(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        System.out.println("Defanged IP Address: " + defang("192.168.1.1"));
    }
}
