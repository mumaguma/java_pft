package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoContactPage();
//    app.getContactHelper().selectContact();
    app.getContactHelper().initContactEdit(2);
    app.getContactHelper().fillContactForm(new ContactData("Bohdan", "Bogucki", "ul. Krzywa 1\n00-001 Warszawa", "+48 789 456 123", "bog@wp.pl"));
    app.getContactHelper().submitGroupModification();
    app.getContactHelper().returnToMainPage();
  }
}
