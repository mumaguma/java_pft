package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test

  public void testContactDeletion() {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().selectContact();
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().clickAccept();
    app.getContactHelper().returnToMainPage();
  }


}
