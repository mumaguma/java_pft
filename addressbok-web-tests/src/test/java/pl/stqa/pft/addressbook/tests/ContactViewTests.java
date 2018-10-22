package pl.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactViewTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName(app.propReader("precondition.contact.name"))
              .withLastName(app.propReader("precondition.contact.lastname"))
              .withStreetAddress(app.propReader("precondition.contact.address"))
              .withPhoneHome(app.propReader("precondition.contact.phone"))
              .withEmail(app.propReader("precondition.contact.email"))
              .withGroup(app.propReader("precondition.contact.group")), true);
    }
  }


  @Test
  public void testContactView() {
    app.goTo().contactPage();
    ContactData contact = app.contact().all().iterator().next();
    app.contact().initContactView(contact.getId());
    String contactInfoFromViewPage = app.contact().infoFromViewPage();
    contactInfoFromViewPage = app.contact().prepareContactInfoForCompare(contactInfoFromViewPage);

    app.contact().moveFromViewToEdit();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
//        System.out.println(contactInfoFromViewPage);
    String mergedContactInfoFromEditForm = app.contact().mergeContactData(contactInfoFromEditForm);
    MatcherAssert.assertThat(contactInfoFromViewPage, CoreMatchers.equalTo(mergedContactInfoFromEditForm ));
  }


}
