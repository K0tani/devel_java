package ru.stqa.pft.adressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jcomander =  new JCommander(generator);
    try {
      jcomander.parse(args);
    } catch (ParameterException ex) {
      jcomander.usage();
      return;
    }
    generator.run();

  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if(format.equals("json")) {
      saveAsJson(contacts, new File(file));
    } else {
      System.out.println("Непонятный формат" + format);
    }

  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(json);
    }
  }


  private  List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstName(String.format("Пётр %s", i)).withMiddleName(String.format("Алеексеевич %s", i))
              .withLastName(String.format("Габрилянов %s", i)).withAddress(String.format("Улица Пушкина Дом %s", i))
              .withHome(String.format("891%s0998877", i)).withMobile(String.format("8916099887%s", i))
              .withWork(String.format("%s916099887", i)).withEmail(String.format("mailNumber%s@mail.ru", i))
              .withEmail2(String.format("mailNumber%s@gmail.com", i)).withEmail3(String.format("mailNumber%s@rambler.ru", i)).withGroup(String.format("test %s", i))
              .withDateForBday(String.format("1%s", i)).withMonthForBday("May").withYearForBday(String.format("199%s",i)).withGroup("test 0"));
    }
    return contacts;

  }

}




