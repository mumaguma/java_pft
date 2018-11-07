package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.GroupData;
import pl.stqa.pft.addressbook.model.GroupMemberData;
import pl.stqa.pft.addressbook.model.GroupMembers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveContactFromGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.db().groupsContacts().size() == 0) {
      if (app.db().contacts().size() == 0) {
        app.goTo().contactPage();
        app.contact().create(new ContactData().withFirstName(app.propReader("precondition.contact.name"))
                .withLastName(app.propReader("precondition.contact.lastname"))
                .withStreetAddress(app.propReader("precondition.contact.address"))
                .withPhoneHome(app.propReader("precondition.contact.phone"))
                .withEmail(app.propReader("precondition.contact.email")), true);
        if (app.db().groups().size() == 0) {
          app.goTo().groupPage();
          app.group().create(new GroupData().withName(app.propReader("precondition.contact.group")));
          app.goTo().contactPage();
        }
        ContactData contact = app.db().contacts().iterator().next();
        GroupData group = app.db().groups().iterator().next();
        app.contact().addToGroup(contact, group);
      }
    }
  }


  @Test
  public void testRemoveContactFromGroup() {
    GroupMembers before = app.db().groupsContacts();
    GroupMemberData groupcontact = app.db().groupsContacts().iterator().next();
    app.contact().removeFromGroup(groupcontact);
    GroupMembers after = app.db().groupsContacts();
    assertThat(after, equalTo(before.without(groupcontact)));
  }
}
