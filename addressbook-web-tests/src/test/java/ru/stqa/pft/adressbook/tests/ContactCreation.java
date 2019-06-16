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
    ContactData contact = new ContactData().withFirstName("Пётр").withMiddleName("Алексеевич").withLastName("Габрилян").withDateForBday("31")
            .withtMonthForBday("May").withYearForBday("1966").withGroup("T2st");
    app.contact().create(contact, true);
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.size() +1));
    assertThat(after, equalTo(before.withAdded
            (contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }


}
