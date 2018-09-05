package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests  extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().contactPage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("Kazimierz").withLastName("Adamowicz").withStreetAddress("Jasna 2").withPhoneHome("551122322").withEmail("mail@me.com").withGroup("test1");
    app.contact().create(contact, true);
    app.goTo().contactPage();
    assertThat(app.contact().count(), equalTo(before.size()+1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

  @Test
  public void testBadContactCreation() {
    app.goTo().contactPage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("Kazi'mierz").withLastName("Adamowicz").withStreetAddress("Jasna 2").withPhoneHome("551122322").withEmail("mail@me.com").withGroup("test1");
    app.contact().create(contact, true);
    app.goTo().contactPage();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }
}
