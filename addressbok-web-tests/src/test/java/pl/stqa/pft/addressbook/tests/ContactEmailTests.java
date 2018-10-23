package pl.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactEmailTests extends TestBase {


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
  public void testContactEmail() {
    app.goTo().contactPage();
    ContactData contact = app.contact().all().iterator().next();
    app.contact().initContactEdit(contact.getId());
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }
}
