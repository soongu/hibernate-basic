package hellojpa;

import java.util.HashSet;

public class ValueMain {

    public static void main(String[] args) {

        HashSet<Address> set = new HashSet<>();

        Address address1 = new Address("city", "street", "11111");
        Address address2 = new Address("city", "street", "11111");
        
        
        set.add(address1);
        set.add(address2);

        System.out.println("address1 == address2 : " + address1.equals(address2));
        System.out.println("address1.hashCode() = " + address1.hashCode());
        System.out.println("address2.hashCode() = " + address2.hashCode());
        System.out.println("set.size() = " + set.size());
    }
}
