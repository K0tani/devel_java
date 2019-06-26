package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class  ContactDelete extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Пётр").withMiddleName("Алексеевич").withLastName("Габрилян").withAddress("улица Пушкина")
              .withHome("878").withMobile("707").withWork("7873").withEmail("123@gmail.com").withEmail2("423@ya.ru").withEmail3("576@rambler.ru").withDateForBday("31")
              .withMonthForBday("May").withYearForBday("1966").withGroup("T2st"), true);
    }
  }

  @Test
  public void testDeleteContact() {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(deletedContact)));
  }

}

