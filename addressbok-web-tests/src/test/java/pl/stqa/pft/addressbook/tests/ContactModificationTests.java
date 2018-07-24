package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoContactPage();
//    app.getContactHelper().selectContact();
    app.getContactHelper().initContactEdit(2);
    app.getContactHelper().fillContactForm(new ContactData("Czeslaw", "Czechowicz", "Warszawa", "+48 123 123 123", "czesio@wp.pl", null), false);
    app.getContactHelper().submitGroupModification();
    app.getContactHelper().returnToMainPage();
  }
}
