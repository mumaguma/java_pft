package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test

  public void testContactDeletion() {
    app.getNavigationHelper().gotoContactPage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createNewContact(new ContactData("Delete", "Me", "a", "112", "a@b.com", "test1"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().clickAccept();
    app.getContactHelper().returnToMainPage();
  }


}
