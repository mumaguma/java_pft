package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.pft.addressbook.model.ContactData;

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

//  public void selectContact() {
//    click(By.name("selected[]"));
//  }

  public void selectContact(int i) {
    click(By.xpath("//input[@id='" + i + "']"));
  }

  public void submitContactDeletion() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void clickAccept() {
    acceptbutton();
  }

  public void initContactEdit(int i) {
    click(By.xpath("//table[@id='maintable']/tbody/tr[" + (i + 1) + "]/td[8]/a/img"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createNewContact(ContactData contactData, boolean creation) {
    initContactCreation();
    fillContactForm(contactData, creation);
    submitContactCreation();
    returnToMainPage();
  }

  public void modifyContact(int changeIndex, ContactData contact) {
    initContactEdit(changeIndex);
    fillContactForm(contact, false);
    submitGroupModification();
    returnToMainPage();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement row : elements) {
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      List<WebElement> tabCells = row.findElements(By.tagName("td"));
      String lastName = tabCells.get(1).getText();
      String firstName = tabCells.get(2).getText();
      ContactData contact = new ContactData(id, firstName, lastName, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }


//  public List<GroupData> getGroupList() {
//    List<GroupData> groups = new ArrayList<GroupData>();
//    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
//    for (WebElement element : elements) {
//      String name = element.getText();
//      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
//      GroupData group = new GroupData(id, name, null, null);
//      groups.add(group);
//    }
//    return groups;
//  }

}

