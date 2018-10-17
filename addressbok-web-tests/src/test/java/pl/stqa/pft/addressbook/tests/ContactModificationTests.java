package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
//    app.goTo().contactPage();
//    if (app.contact().all().size() == 0) {
    if(app.db().contacts().size() == 0){
      app.goTo().contactPage();
      app.contact().create(new ContactData().withFirstName(app.propReader("precondition.contact.name"))
              .withLastName(app.propReader("precondition.contact.lastname"))
              .withStreetAddress(app.propReader("precondition.contact.address"))
              .withPhoneHome(app.propReader("precondition.contact.phone"))
              .withEmail(app.propReader("precondition.contact.email"))
              .withGroup(app.propReader("precondition.contact.group")), true);
    }
  }

  @Test
  public void testContactModification() {
//    Contacts before = app.contact().all();
    app.goTo().contactPage();
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId())
            .withFirstName(app.propReader("modified.contact.name"))
            .withLastName(app.propReader("modified.contact.lastname"))
            .withStreetAddress(app.propReader("modified.contact.address"))
            .withPhoneHome(app.propReader("modified.contact.phone"))
            .withEmail(app.propReader("modified.contact.email"))
            .withGroup(app.propReader("modified.contact.group"));
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
//    Contacts after = app.contact().all();
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

  }
}
