package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test

  public void testContactDeletion() {
    app.getNavigationHelper().gotoContactPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createNewContact(new ContactData("Delete", "Me", "a", "112", "a@b.com", "test1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    int deleteId = before.get(before.size() - 1).getId();

    app.getContactHelper().selectContact(deleteId);
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().clickAccept();
    app.getContactHelper().returnToMainPage();

    before.remove(before.size() - 1);
    List<ContactData> after = app.getContactHelper().getContactList();
//    Assert.assertEquals(after.size(), before.size());
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }


}
