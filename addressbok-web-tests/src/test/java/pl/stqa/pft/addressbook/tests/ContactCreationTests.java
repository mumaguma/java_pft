package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

public class ContactCreationTests  extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().contactPage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("Kazimierz").withLastName("Adamowicz").withStreetAddress("Jasna 2").withPhoneHome("551122322").withEmail("mail@me.com").withGroup("test1");
    app.contact().create(contact, true);
    app.goTo().contactPage();
    Set<ContactData> after = app.contact().all();

//    Assert.assertEquals(after.size(), before.size()+1);
//    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);


    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);

    }
}
