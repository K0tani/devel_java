package ru.stqa.pft.adressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.adressbook.model.ContactData;

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

  @Parameter(names = "-d", description = "Date format")
  public String format;

  public static void  main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    }catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveAsCsv(contacts,new File(file));
    } else if(format.equals("xml")) {
      saveAsXml(contacts,new File(file));
    } else if(format.equals("json")) {
      saveAsJson(contacts,new File(file));
    } else {

      System.out.println("Непонятный формат" + format);
    }
  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try (Writer writer = new FileWriter(file);) {
      writer.write(json);
    }
  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    try (Writer writer = new FileWriter(file);) {
      writer.write(xml);
    }
  }


  private  void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    try (Writer writer = new FileWriter(file)) {
      for (ContactData contact : contacts) {
        writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n",contact.withFirstName("Пётр"),contact.withMiddleName("Алексеевич"),
                contact.withLastName("Габрилян"), contact.withAddress("улица Пушкина"),contact.withHome("878"),
                contact.withMobile("707"),contact.withWork("7873"),contact.withEmail("123@gmail.com")
                ,contact.withEmail2("423@ya.ru"),contact.withEmail3("576@rambler.ru").withDateForBday("31")
                ,contact.withMonthForBday("May"),contact.withYearForBday("1966"),contact.withGroup("1st")));
      }
    }
  }

  private  List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstName(String.format("Пётр %s", i)).withMiddleName(String.format("Алеексеевич %s", i))
              .withLastName(String.format("Габрилянов %s", i)).withAddress(String.format("Улица Пушкина Дом %s", i))
              .withHome(String.format("891%s0998877", i)).withMobile(String.format("8916099887%s", i))
              .withWork(String.format("%s916099887", i)).withEmail(String.format("mailNumber%s@mail.ru", i))
              .withEmail2(String.format("mailNumber%s@gmail.com", i)).withEmail3(String.format("mailNumber%s@rambler.ru", i)));
    }
    return contacts;
  }

}
