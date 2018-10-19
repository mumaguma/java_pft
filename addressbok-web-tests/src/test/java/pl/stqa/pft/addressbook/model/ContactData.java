package pl.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")

public class ContactData {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;
  @Expose
  @Column(name = "firstname")
  @Type(type = "string")
  private String firstName;
  @Expose
  @Column(name = "lastname")
  @Type(type = "string")
  private String lastName;
  @Expose
  @Column(name = "middlename")
  @Type(type = "string")
  private String middleName;
  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String streetAddress;
  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String phoneHome;
  @Expose
  @Column(name = "phone2")
  @Type(type = "text")
  private String phoneHomeTwo;
  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String phoneMobile;
  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String phoneWork;
  @Expose
  @Transient
  private String allPhones;
  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String email;
  @Expose
  @Column(name = "email2")
  @Type(type = "text")
  private String email2;
  @Expose
  @Column(name = "email3")
  @Type(type = "text")
  private String email3;
  @Expose
  @Transient
  private String group;
  @Expose
  @Transient
  private String allEmails;
  @Expose
  @Column(name = "nickname")
  private String nickname;
  @Expose
  @Column(name = "title")
  private String title;
  @Expose
  @Column(name = "company")
  private String company;
  @Expose
  @Column(name = "fax")
  @Type(type = "text")
  private String fax;
  @Expose
  @Column(name = "homepage")
  @Type(type = "text")
  private String homepage;
  @Expose
  @Transient
  private String bday;
  @Expose
  @Column(name = "bday")
  private Byte bdayAsByte;
  @Expose
  private String bmonth;
  @Expose
  private String byear;
  @Expose
  @Transient
  private String aday;
  @Expose
  @Column(name = "aday")
  private Byte adayAsByte;
  @Expose
  private String amonth;
  @Expose
  private String ayear;
  @Expose
  @Column(name = "address2")
  @Type(type = "text")
  private String address2;
  @Expose
  @Column(name = "notes")
  @Type(type = "text")
  private String notes;
  @XStreamOmitField
  @Column(name = "photo")
  @Type(type = "text")
//  @Transient
  private String photo;

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getStreetAddress() {
    return streetAddress;
  }

  public String getPhoneHome() {
    return phoneHome;
  }

  public String getPhoneMobile() {
    return phoneMobile;
  }

  public String getPhoneWork() {
    return phoneWork;
  }

  public String getPhoneHomeTwo() {
    return phoneHomeTwo;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getGroup() {
    return group;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getFax() {
    return fax;
  }

  public String getHomepage() {
    return homepage;
  }

  public String getBday() {
    return bday;
  }

  public Byte getBdayAsByte() {
    return bdayAsByte;
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getByear() {
    return byear;
  }

  public String getAday() {
    return aday;
  }

  public int getAdayAsByte() {
    return adayAsByte;
  }

  public String getAmonth() {
    return amonth;
  }

  public String getAyear() {
    return ayear;
  }

  public String getAddress2() {
    return address2;
  }

  public String getNotes() {
    return notes;
  }

  public File getPhoto() {
    if (photo != null) {
      return new File(photo);
    } else {
      return null;
    }
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ContactData withStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email) {
    this.email2 = email;
    return this;
  }

  public ContactData withEmail3(String email) {
    this.email3 = email;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withPhoneHome(String phoneHome) {
    this.phoneHome = phoneHome;
    return this;
  }

  public ContactData withPhoneMobile(String phoneMobile) {
    this.phoneMobile = phoneMobile;
    return this;
  }

  public ContactData withPhoneWork(String phoneWork) {
    this.phoneWork = phoneWork;
    return this;
  }

  public ContactData withPhoneHomeTwo(String phoneHomeTwo) {
    this.phoneHomeTwo = phoneHomeTwo;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withFax(String fax) {
    this.fax = fax;
    return this;
  }

  public ContactData withHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  public ContactData withBday(String bday) {
    this.bday = bday;
    return this;
  }

  public ContactData setBdayAsByte(Byte bdayAsByte) {
    this.bdayAsByte = bdayAsByte;
    return this;
  }


  public ContactData withBmonth(String bmonth) {
    this.bmonth = bmonth;
    return this;
  }

  public ContactData withByear(String byear) {
    this.byear = byear;
    return this;
  }

  public ContactData withAday(String aday) {
    this.aday = aday;
    return this;
  }

  public ContactData withAdayAsByte(Byte adayAsByte) {
    this.adayAsByte = adayAsByte;
    return this;
  }

  public ContactData withAmonth(String amonth) {
    this.amonth = amonth;
    return this;
  }

  public ContactData withAyear(String ayear) {
    this.ayear = ayear;
    return this;
  }

  public ContactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public ContactData withNotes(String notes) {
    this.notes = notes;
    return this;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(middleName, that.middleName) &&
            Objects.equals(streetAddress, that.streetAddress) &&
            Objects.equals(phoneHome, that.phoneHome) &&
            Objects.equals(phoneHomeTwo, that.phoneHomeTwo) &&
            Objects.equals(phoneMobile, that.phoneMobile) &&
            Objects.equals(phoneWork, that.phoneWork) &&
            Objects.equals(email, that.email) &&
            Objects.equals(email2, that.email2) &&
            Objects.equals(email3, that.email3) &&
            Objects.equals(nickname, that.nickname) &&
            Objects.equals(title, that.title) &&
            Objects.equals(company, that.company) &&
            Objects.equals(fax, that.fax) &&
            Objects.equals(homepage, that.homepage) &&
            Objects.equals(bday, that.bday) &&
            Objects.equals(bmonth, that.bmonth) &&
            Objects.equals(byear, that.byear) &&
            Objects.equals(aday, that.aday) &&
            Objects.equals(amonth, that.amonth) &&
            Objects.equals(ayear, that.ayear) &&
            Objects.equals(address2, that.address2) &&
            Objects.equals(notes, that.notes) &&
            Objects.equals(photo, that.photo);
  }

  @Override
  public int hashCode() {
    if (firstName == null) {  firstName = "";}
    if (lastName == null) { lastName = "";}
    if (middleName == null) { middleName = "";}
    if (streetAddress == null) { streetAddress = "";}
    if (phoneHome == null) { phoneHome = "";}
    if (phoneMobile == null) { phoneMobile = "";}
    if (phoneWork == null) { phoneWork = "";}
    if (email == null) { email = "";}
    if (phoneHomeTwo == null) { phoneHomeTwo = "";}
    if (email2 == null) { email2 = "";}
    if (email3 == null) { email3 = "";}
    if (nickname == null) { nickname = "";}
    if (title == null) { title = "";}
    if (company == null) { company = "";}
    if (fax == null) { fax = "";}
    if (homepage == null) { homepage = "";}
    if (bday == "0") { bday = "";}
    if (bday == null) { bday = "";}
    if (bmonth == "-") { bmonth = "";}
    if (bmonth == null) { bmonth = "";}
    if (byear == null) { byear = "";}
    if (aday == "0") { aday = "";}
    if (aday == null) { aday = "";}
    if (amonth == "-") { amonth = "";}
    if (amonth == null) { amonth = "";}
    if (ayear == null) { ayear = "";}
    if (address2 == null) { address2 = "";}
    if (notes == null) { notes = "";}
    if (photo == null) { photo = "";}
    group = "";
    bdayAsByte = 0;
    adayAsByte = 0;
    allPhones = "";
    allEmails = "";

    return Objects.hash(id, firstName, lastName, middleName, streetAddress, phoneHome, phoneHomeTwo, phoneMobile,
            phoneWork, email, email2, email3, nickname, title, company, fax, homepage,
            bday, bmonth, byear, aday, amonth, ayear, address2, notes);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

}
