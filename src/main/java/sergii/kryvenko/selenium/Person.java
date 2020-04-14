package sergii.kryvenko.selenium;

public class Person {

    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String postcode;
    private String country;
    private String region;
    private String commentInOrder;

    public Person() {
    }
    
    public Person(String openccart) {
        this.firstName = "John";
        this.lastName = "Shepard";
        this.company = "freelancer";
        this.address1 = "USA";
        this.address2 = "England";
        this.city = "London";
        this.postcode = "123456";
        this.country = "United Kingdom";
        this.region = "Cambridgeshire";
        this.commentInOrder = "Comments About Your Order";
    }

    public Person(String firstName, String lastName, String company,
            String address1, String address2, String city, String postcode,
            String country, String region, String commentInOrder) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.region = region;
        this.commentInOrder = commentInOrder;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCommentInOrder() {
        return commentInOrder;
    }

    public void setCommentInOrder(String commentInOrder) {
        this.commentInOrder = commentInOrder;
    }

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName
                + ", company=" + company + ", address1=" + address1
                + ", address2=" + address2 + ", city=" + city + ", postcode="
                + postcode + ", country=" + country + ", region=" + region
                + ", commentInOrder=" + commentInOrder + "]";
    }

    
}
