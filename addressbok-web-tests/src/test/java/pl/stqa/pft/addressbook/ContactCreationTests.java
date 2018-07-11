package pl.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests  extends TestBase {

  @Test
  public void testContactCreation() {
    app.initContactCreation();
    app.fillContactForm(new ContactData("Adam", "Adamowicz", "ul. Prosta 1\n00-001 Warszawa", "+48 123 456 789", "adam@wp.pl"));
    app.submitContactCreation();
    app.returnToMainPage();
  }

}
