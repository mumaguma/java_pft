package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions(){
    app.getNavigationHelper().gotoContactPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createNewContact(new ContactData("Precreated", "Me", "a", "112", "a@b.com", "test1"), true);
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.getContactHelper().getContactList();
    int changeIndex = before.size();
    ContactData contact = new ContactData(before.get(changeIndex - 1).getId(), "Norbert", "Wacławski", "Jasna 2", "551122322", "mail@me.com", "test1");
    app.getContactHelper().modifyContact(changeIndex, contact);
    List<ContactData> after = app.getContactHelper().getContactList();
//    Assert.assertEquals(after.size(), before.size());
    before.remove(changeIndex - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
