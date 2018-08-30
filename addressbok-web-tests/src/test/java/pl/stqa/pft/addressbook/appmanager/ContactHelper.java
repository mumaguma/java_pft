package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;
import java.util.ArrayList;
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
    returnToMainPage();
  }

  public void modify(ContactData contact) {
    initContactEdit(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    returnToMainPage();
  }

  public void delete(ContactData contact) {
    select(contact.getId());
    submitContactDeletion();
    clickAccept();
    returnToMainPage();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement row : elements) {
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      List<WebElement> tabCells = row.findElements(By.tagName("td"));
      String lastName = tabCells.get(1).getText();
      String firstName = tabCells.get(2).getText();
      contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
    }
    return contacts;
  }

  public Contacts all() {
    Contacts contacts= new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement row : elements) {
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      List<WebElement> tabCells = row.findElements(By.tagName("td"));
      String lastName = tabCells.get(1).getText();
      String firstName = tabCells.get(2).getText();
      contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
    }
    return contacts;
  }
}

