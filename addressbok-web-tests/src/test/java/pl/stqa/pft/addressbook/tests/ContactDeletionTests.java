package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if(app.db().contacts().size() == 0) {
      app.goTo().contactPage();
//    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName(app.propReader("precondition.contact.name"))
              .withLastName(app.propReader("precondition.contact.lastname"))
              .withStreetAddress(app.propReader("precondition.contact.address"))
              .withPhoneHome(app.propReader("precondition.contact.phone"))
              .withEmail(app.propReader("precondition.contact.email"))
              .withGroup(app.propReader("precondition.contact.group")), true);
    }
  }

  @Test
  public void testContactDeletion() {
    Contacts before = app.db().contacts();
//    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
//    assertThat(app.contact().count(), equalTo(before.size() - 1));
//    Contacts after = app.contact().all();
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
