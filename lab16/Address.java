package lab16;

public class Address {
    private String cityName;
    private int zipCode;
    private String streetName;
    private int buildingNumber;
    private char buildingLetter;
    private int appartmentNumber;
    public Address EMPTY_ADDRESS;
    public String getCityName() {
        return cityName;
    }
    public int getZipCode() {
        return zipCode;
    }
    public String getStreetName() {
        return streetName;
    }
    public int getBuildingNumber() {
        return buildingNumber;
    }
    public char getBuildingLetter() {
        return buildingLetter;
    }
    public int getAppartmentNumber() {
        return appartmentNumber;
    }
}
