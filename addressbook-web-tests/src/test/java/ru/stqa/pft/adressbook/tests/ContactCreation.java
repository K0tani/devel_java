package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreation extends TestBase{

  @Test
  public void ContactCreation() throws Exception {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("Пётр").withMiddleName("Алексеевич").withLastName("Габрилян").withAddress("улица Пушкина")
            .withHome("878").withMobile("707").withWork("7873").withEmail("123@gmail.com").withEmail2("423@ya.ru").withEmail3("576@rambler.ru").withDateForBday("31")
            .withMonthForBday("May").withYearForBday("1966").withGroup("T2st");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded
            (contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }


}
