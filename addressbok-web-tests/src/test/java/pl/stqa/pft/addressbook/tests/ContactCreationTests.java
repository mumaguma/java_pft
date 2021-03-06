package pl.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;
import pl.stqa.pft.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File(app.propReader("createcontacts.json.file"))))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
      }.getType());
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider = "validContactsFromJson")
  public void testContactCreation(ContactData contact) {
    app.goTo().contactPage();
//    Contacts before = app.contact().all();
    Contacts before = app.db().contacts();
    File photo = new File("src/test/resources/avatar.png");
    app.contact().create(contact.withPhoto(photo), true);
    app.goTo().contactPage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
//    Contacts after = app.contact().all();
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadContactCreation() {
    Groups groups = app.db().groups();
    File photo = new File("src/test/resources/avatar.png");
    ContactData contact = new ContactData().withFirstName(app.propReader("create.contact.bad.firstname"))
            .withLastName(app.propReader("modified.contact.lastname"))
            .withStreetAddress(app.propReader("modified.contact.address"))
            .withPhoneHome(app.propReader("modified.contact.phone"))
            .withEmail(app.propReader("modified.contact.email"))
            .withPhoto(photo).inGroup(groups.iterator().next())
//            .withGroup(app.propReader("modified.contact.group"))
            ;
    app.goTo().contactPage();
    Contacts before = app.db().contacts();
//    Contacts before = app.contact().all();
    app.contact().create(contact, true);
    app.goTo().contactPage();
//    assertThat(app.contact().count(), equalTo(before.size()));
//    Contacts after = app.contact().all();
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before));
  }

}

