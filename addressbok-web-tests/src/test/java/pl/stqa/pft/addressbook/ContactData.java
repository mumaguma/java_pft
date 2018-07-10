package pl.stqa.pft.addressbook;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String streetAddress;
  private final String phoneHome;
  private final String email;

  public ContactData(String firstName, String lastName, String streetAddress, String phoneHome, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.streetAddress = streetAddress;
    this.phoneHome = phoneHome;
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getStreetAddress() {
    return streetAddress;
  }

  public String getPhoneHome() {
    return phoneHome;
  }

  public String getEmail() {
    return email;
  }
}
