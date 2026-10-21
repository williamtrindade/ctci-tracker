package CTCI125ShallowVsDeepCopy;

import java.util.List;

public class Person {
    private String name;
    private Address address;
    private List<String> phones;

    public Person(String name, Address address, List<String> phones) {
        this.name = name;
        this.address = address;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public List<String> getPhones() {
        return phones;
    }
}
