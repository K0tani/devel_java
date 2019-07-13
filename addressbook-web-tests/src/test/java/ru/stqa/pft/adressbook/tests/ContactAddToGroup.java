package ru.stqa.pft.adressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddToGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Пётр").withMiddleName("Алексеевич")
              .withLastName("Габрилян").withAddress("улица Пушкина")
              .withHome("878").withMobile("707").withWork("7873")
              .withEmail("123@gmail.com").withEmail2("423@ya.ru")
              .withEmail3("576@rambler.ru").withDateForBday("31")
              .withMonthForBday("May").withYearForBday("1966"),true);
    }
  }

  @Test
  public void testAddContactToGroup() {
    Contacts beforeContacts =  app.db().contacts();
    Groups beforeGroups = app.db().groups();

    ContactData contact = beforeContacts.iterator().next();
    if (contact.getGroups().size() < beforeGroups.size()) {
      for (GroupData group : beforeGroups) {
        if (!group.getContacts().contains(contact)) {
          app.goTo().groupPage();
          app.contact().addGroup(contact, group);
          assertThat(app.db().contactById(contact.getId()).iterator().next().getGroups(), equalTo(contact.getGroups().withAdded(group)));
          break;
        }
      }
    } else {
      GroupData newGroup = new GroupData().withName(app.contact().uniqueGroupName()).withHeader("test2").withFooter("test3");

      app.goTo().groupPage();
      app.group().create(newGroup);
      newGroup.withId(app.db().groups().stream().mapToInt((g) -> g.getId()).max().getAsInt());
      app.contact().addGroup(contact, newGroup);
      assertThat(app.db().contactById(contact.getId()).iterator().next().getGroups(), equalTo(contact.getGroups().withAdded(newGroup)));
    }
  }
}