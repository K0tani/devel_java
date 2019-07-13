package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactBaseInfo extends TestBase{

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Пётр").withMiddleName("Алексеевич").withLastName("Габрилян").withAddress("улица Пушкина")
              .withHome("878").withMobile("707").withWork("7873").withEmail("123@gmail.com").withEmail2("423@ya.ru").withEmail3("576@rambler.ru").withDateForBday("31")
              .withMonthForBday("May").withYearForBday("1966"), true);
    }
  }


  @Test
  public void TestContactPhones() {
    ContactData contact = app.contact().allBasicInfo().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().basicInfoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3()).
            stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHome(), contact.getMobile(), contact.getWork()).
            stream().filter((s) -> ! s.equals(""))
            .map(ContactBaseInfo::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }
}

