package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Precreated").withLastName("Entry")
              .withStreetAddress("Ateńska 219\n99-999 Chrząszcze-Rzewuszyce Kolonia")
              .withPhoneHome("123").withEmail("mailx@me.com").withGroup("test1"), true);
    }
  }

  @Test
  public void testContactAddress() {
    app.goTo().contactPage();
    ContactData contact = app.contact().all().iterator().next();
    app.contact().initContactEdit(contact.getId());
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);;
    assertThat(contact.getStreetAddress(), equalTo(contactInfoFromEditForm.getStreetAddress()));

  }


}
