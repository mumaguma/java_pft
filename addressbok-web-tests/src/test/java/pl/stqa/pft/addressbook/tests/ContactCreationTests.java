package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests  extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().contactPage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withFirstName("Kazimierz").withLastName("Adamowicz").withStreetAddress("Jasna 2").withPhoneHome("551122322").withEmail("mail@me.com").withGroup("test1");
    app.contact().create(contact, true);
    app.goTo().contactPage();
    List<ContactData> after = app.contact().list();

//    Assert.assertEquals(after.size(), before.size()+1);

    before.add(contact);
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    }
}
