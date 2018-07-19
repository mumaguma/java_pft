package pl.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {

@Test

public void testContactDeletion() {
  app.getNavigationHelper().gotoContactPage();
  app.getContactHelper().selectContact();
  app.getContactHelper().submitContactDeletion();
  app.getContactHelper().clickAccept();


  app.getContactHelper().returnToMainPage();
}



}
