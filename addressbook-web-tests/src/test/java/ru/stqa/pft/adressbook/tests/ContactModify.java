package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.GroupData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModify extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.db().contacts().size() == 0) {
      app.goTo().groupPage();
      if (app.db().groups().size() == 0) {
        app.group().create(new GroupData().withName("test 0"));
      }
      app.contact().create(new ContactData().withFirstName("Пётр").withMiddleName("Алексеевич")
              .withLastName("Габрилян").withAddress("улица Пушкина")
              .withHome("878").withMobile("707").withWork("7873")
              .withEmail("123@gmail.com").withEmail2("423@ya.ru")
              .withEmail3("576@rambler.ru").withDateForBday("31")
              .withMonthForBday("May").withYearForBday("1966"), true);
    }
  }

  @Test
  public void contactModify() throws Exception{
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Сергей")
            .withMiddleName("Аоронович").withLastName("Чихачёв")
            .withAddress("улица Пушкина, Дом Калатушкина").withHome("89170009933")
            .withMobile("89173339736").withWork("89150339443").withEmail("999@ya.ru")
            .withEmail2("r_mbl3r@gmail.com").withEmail3("octag0n@rambler.ru")
            .withDateForBday("1").withMonthForBday("May").withYearForBday("1991");
    app.contact().modify(contact, false);
    assertEquals(app.contact().count(), before.size());
    Contacts after = app.db().contacts();
    assertThat(after, equalTo
            (before.without(modifiedContact).withAdded(contact)));
  }

  private void aassertEquals(int count, int size) {
  }


}
