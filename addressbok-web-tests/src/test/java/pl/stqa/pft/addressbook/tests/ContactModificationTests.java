package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().contactPage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData("Precreated", "Me", "a", "112", "a@b.com", "test1"), true);
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    int changeIndex = before.size();
    ContactData contact = new ContactData(before.get(changeIndex - 1).getId(), "Norbert", "Wacławski", "Jasna 2", "551122322", "mail@me.com", "test1");
    app.contact().modify(changeIndex, contact);
    List<ContactData> after = app.contact().list();
//    Assert.assertEquals(after.size(), before.size());
    before.remove(changeIndex - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
