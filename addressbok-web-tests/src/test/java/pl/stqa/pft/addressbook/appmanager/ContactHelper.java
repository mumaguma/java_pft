package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToMainPage() {
    wd.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    wd.findElement(By.id("content")).click();
  }

  public void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getStreetAddress());
    type(By.name("home"), contactData.getPhoneHome());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void initContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void select(int i) {
    click(By.xpath("//input[@id='" + i + "']"));
  }

  public void submitContactDeletion() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void clickAccept() {
    acceptbutton();
  }

  public void initContactEdit(int i) {
    click(By.xpath("//a[@href='edit.php?id=" + i + "']"));
  }

  public void initContactView(int i) {
    click(By.xpath("//a[@href='view.php?id=" + i + "']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void create(ContactData contactData, boolean creation) {
    initContactCreation();
    fillContactForm(contactData, creation);
    submitContactCreation();
    contactCache = null;
    returnToMainPage();
  }

  public void modify(ContactData contact) {
    initContactEdit(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    returnToMainPage();
  }

  public void delete(ContactData contact) {
    select(contact.getId());
    submitContactDeletion();
    clickAccept();
    contactCache = null;
    returnToMainPage();
  }


  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement row : elements) {
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      List<WebElement> tabCells = row.findElements(By.tagName("td"));
      String lastName = tabCells.get(1).getText();
      String firstName = tabCells.get(2).getText();
      String streetAddress = tabCells.get(3).getText();
      String allEmails = tabCells.get(4).getText();
      String allPhones = tabCells.get(5).getText();
      contactCache.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName)
              .withAllPhones(allPhones).withAllEmails(allEmails).withStreetAddress(streetAddress));
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String streetaddress = wd.findElement(By.name("address")).getAttribute("value");
    String phonehome = wd.findElement(By.name("home")).getAttribute("value");
    String phonemobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String phonework = wd.findElement(By.name("work")).getAttribute("value");
    String phonehometwo = wd.findElement(By.name("phone2")).getAttribute("value");
    String nickname = wd.findElement(By.name("nickname")).getAttribute("value");
    String title = wd.findElement(By.name("title")).getAttribute("value");
    String company = wd.findElement(By.name("company")).getAttribute("value");
    String fax = wd.findElement(By.name("fax")).getAttribute("value");
    String homepage = wd.findElement(By.name("homepage")).getAttribute("value");
    String address2 = wd.findElement(By.name("address2")).getAttribute("value");
    String notes = wd.findElement(By.name("notes")).getAttribute("value");

    String bday =  wd.findElement(By.name("bday")).getAttribute("value");
    String bmonth = wd.findElement(By.name("bmonth")).getAttribute("value");
    String byear = wd.findElement(By.name("byear")).getAttribute("value");
    String aday = wd.findElement(By.name("aday")).getAttribute("value");
//    String amonth = wd.findElement(By.name("amonth")).getText();
    Select amonthSelect = new Select(wd.findElement(By.xpath("//div[4]/form[1]/select[4]")));
    String amonth = amonthSelect.getFirstSelectedOption().getText();
    String ayear = wd.findElement(By.name("ayear")).getAttribute("value");


    wd.navigate().back();
    return new ContactData().withId(contact.getId())
            .withFirstName(firstname).withMiddleName(middlename).withLastName(lastname)
            .withPhoneHome(phonehome).withPhoneMobile(phonemobile).withPhoneWork(phonework)
            .withPhoneHomeTwo(phonehometwo)
            .withEmail(email).withEmail2(email2).withEmail3(email3)
            .withStreetAddress(streetaddress)
            .withNickname(nickname).withTitle(title).withCompany(company)
            .withFax(fax).withHomepage(homepage).withAddress2(address2).withNotes(notes)
            .withBday(bday).withBmonth(bmonth).withByear(byear)
            .withAday(aday).withAmonth(amonth).withAyear(ayear);
  }

  public String infoFromViewPage() {
    String fulldetails = wd.findElement(By.xpath("//div[@id='content']")).getText();
    return fulldetails;
  }

  public void moveFromViewToEdit() {
    click(By.xpath("//input[@value='Modify']"));
  }

  public String prepareContactInfoForCompare(String contactString) {
    contactString = contactString.replaceAll("(?m)^Member of: (.){1,}$", "");
    contactString = Pattern.compile("(?m)(^Anniversary (.){1,}) \\(.{1,}\\)$").matcher(contactString).replaceFirst("$1");
    contactString = contactString.replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
    return contactString;
  }

  public String mergeContactData(ContactData contact) {
    StringBuilder mergedDetails = new StringBuilder();
    if (! contact.getFirstName().isEmpty()) mergedDetails.append(contact.getFirstName() + " ");
    if (! contact.getMiddleName().isEmpty()) mergedDetails.append(contact.getMiddleName() + " ");
    if (! contact.getLastName().isEmpty()) mergedDetails.append(contact.getLastName());
    if (mergedDetails.length() > 0) mergedDetails.append("\n");
    if (! contact.getNickname().isEmpty()) mergedDetails.append(contact.getNickname() + "\n");
    if (! contact.getTitle().isEmpty()) mergedDetails.append(contact.getTitle() + "\n");
    if (! contact.getCompany().isEmpty()) mergedDetails.append(contact.getCompany() + "\n");
    if (! contact.getStreetAddress().isEmpty()) mergedDetails.append(contact.getStreetAddress() + "\n");
    if (! contact.getPhoneHome().isEmpty()) mergedDetails.append("H: " + contact.getPhoneHome() + "\n");
    if (! contact.getPhoneMobile().isEmpty()) mergedDetails.append("M: " + contact.getPhoneMobile() + "\n");
    if (! contact.getPhoneWork().isEmpty()) mergedDetails.append("W: " + contact.getPhoneWork() + "\n");
    if (! contact.getFax().isEmpty()) mergedDetails.append("F: " + contact.getFax() + "\n");
    if (! contact.getEmail().isEmpty()) mergedDetails.append(contact.getEmail() + "\n");
    if (! contact.getEmail2().isEmpty()) mergedDetails.append(contact.getEmail2() + "\n");
    if (! contact.getEmail3().isEmpty()) mergedDetails.append(contact.getEmail3() + "\n");
    if (! contact.getHomepage().isEmpty()) {
      mergedDetails.append("Homepage:\n" + contact.getHomepage().replaceFirst("^(http[s]?://)","") + "\n");
    }


    if (! (contact.getBday().equals("0") && contact.getBmonth().equals("-") && contact.getByear().isEmpty())) {
      mergedDetails.append("Birthday ");
      if (! contact.getBday().equals("0")) mergedDetails.append(contact.getBday() + ". ");
      if (! contact.getBmonth().equals("-")) mergedDetails.append(contact.getBmonth() + " ");
      if (!contact.getByear().isEmpty()) mergedDetails.append(contact.getByear());
      mergedDetails.append("\n");
    }
    if (! (contact.getAday().equals("0") && contact.getAmonth().equals("-") && contact.getAyear().isEmpty())) {
      mergedDetails.append("Birthday ");
      if (!contact.getAday().equals("0")) mergedDetails.append(contact.getAday() + ". ");
      if (!contact.getAmonth().equals("-")) mergedDetails.append(contact.getAmonth() + " ");
      if (!contact.getAyear().isEmpty()) mergedDetails.append(contact.getAyear());
      mergedDetails.append("\n");
    }
    if (! contact.getAddress2().isEmpty()) mergedDetails.append(contact.getAddress2() + "\n");
    if (! contact.getPhoneHomeTwo().isEmpty()) mergedDetails.append("P: " + contact.getPhoneHomeTwo() + "\n");
    if (! contact.getNotes().isEmpty()) mergedDetails.append(contact.getNotes() + "\n");
    String mergeddetailsstring = mergedDetails.toString();
    mergeddetailsstring  = mergeddetailsstring.replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
//  System.out.println(mergeddetailsstring);
  return mergeddetailsstring;
  }


}

