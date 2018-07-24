package pl.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String streetAddress;
  private final String phoneHome;
  private final String email;
  private String group;

  public ContactData(String firstName, String lastName, String streetAddress, String phoneHome, String email, String group) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.streetAddress = streetAddress;
    this.phoneHome = phoneHome;
    this.email = email;
    this.group = group;
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

  public String getGroup() {
    return group;
  }
}
