package ru.stqa.pft.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import static org.testng.Assert.assertEquals;

public class ContactModify extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
      if (app.contact().all().size() == 0) {
        app.contact().create(new ContactData().withFirstName("Пётр").withMiddleName("Алексеевич").withLastName("Габрилян").withDateForBday("31")
                .withtMonthForBday("May").withYearForBday("1966").withGroup("T2st"), true);
      }
  }

  @Test
  public void contactModify() {

    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Пётр").withMiddleName("Алексеевич").withLastName("Габрилян").withDateForBday("31")
            .withtMonthForBday("May").withYearForBday("1966").withGroup(null);
    app.contact().modify(contact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size());
    MatcherAssert.assertThat(after, CoreMatchers.equalTo
            (before.without(modifiedContact).withAdded(contact)));
  }


}
