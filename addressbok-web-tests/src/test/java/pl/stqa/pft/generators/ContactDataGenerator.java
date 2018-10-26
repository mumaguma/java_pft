package pl.stqa.pft.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import pl.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;


  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json")) {
      saveAsJson(contacts, new File(file));
    } else {
      System.out.println("Data format unknown: " + format);
    }
  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try(Writer writer = new FileWriter(file)) {
      writer.write(json);
    }
  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    try(Writer writer = new FileWriter(file)) {
      writer.write(xml);
    }
  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    try(Writer writer = new FileWriter(file)) {
      for (ContactData contact : contacts) {
        writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n",
                contact.getFirstName(), contact.getLastName(), contact.getMiddleName(),
                contact.getStreetAddress(), contact.getPhoneHome(), contact.getPhoneMobile(), contact.getPhoneWork(),
                contact.getPhoneHomeTwo(), contact.getEmail(), contact.getEmail2(), contact.getEmail3(),
//                contact.getGroup(),
                contact.getNickname(), contact.getTitle(), contact.getCompany(), contact.getFax(),
                contact.getHomepage(), contact.getBday(), contact.getBmonth(), contact.getByear(),
                contact.getAday(), contact.getAmonth(), contact.getAyear(), contact.getAddress2(), contact.getNotes()));
      }
    }
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<>();
    String[] monthName = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstName(String.format("TestnameF %s", i))
              .withLastName(String.format("TestnameL %s", i)).withMiddleName(String.format("I%s", i))
              .withStreetAddress(String.format("Test Street %s", i))
              .withPhoneHome(String.format("1231231%s", i))
              .withPhoneMobile(String.format("1231231%s", i))
              .withPhoneWork(String.format("1231231%s", i))
              .withPhoneHomeTwo(String.format("1231231%s", i)).withEmail(String.format("def%s@stu%s.com", i, i))
              .withEmail2(String.format("bcd%s@xyz%s.com", i, i))
              .withEmail3(String.format("abd%s@zxc%s.com", i, i))
              .withNickname(String.format("testnick%s", i)) // .withGroup("test")
              .withTitle(String.format("testtitle%s", i))
              .withCompany(String.format("testcorp %s", i))
              .withFax(String.format("9999999%s", i))
              .withHomepage(String.format("http://page%s.com/", i))
              .withBday(String.valueOf(i % 28))
              .withBmonth(monthName[i % 12])
              .withByear(String.format("19%s%s", i % 10, i % 10))
              .withAday(String.valueOf(i % 28))
              .withAmonth(monthName[11 - (i % 12)])
              .withAyear(String.format("201%s",i % 10))
              .withAddress2(String.format("addresstwo %s", i))
              .withNotes(String.format("notes %s", i)));
    }
    return contacts;
  }

}
