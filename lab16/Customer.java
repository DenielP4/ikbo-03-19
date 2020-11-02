package lab16;

public final class Customer {
    private String firstName;
    private String secondName;
    private int age;
    private Address address;
    private static Customer MATURE_UNKNOWN_CUSTOMER;
    private static Customer NOT_MATURE_UNKNOWN_CUSTOMER;
    public String getFirstName() {
        return firstName;
    }
    public String getSecondName() {
        return secondName;
    }
    public int getAge() {
        return age;
    }
    public Address getAddress() {
        return address;
    }
}