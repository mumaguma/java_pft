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
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String streetaddress = wd.findElement(By.name("address")).getAttribute("value");
    String phonehome = wd.findElement(By.name("home")).getAttribute("value");
    String phonemobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String phonework = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
            .withPhoneHome(phonehome).withPhoneMobile(phonemobile).withPhoneWork(phonework)
            .withEmail(email).withEmail2(email2).withEmail3(email3)
            .withStreetAddress(streetaddress);

  }
}

