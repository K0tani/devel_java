package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactAdd extends TestBase{

  @Test
  public void testAddContact() throws Exception {
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Пётр", "Алексеевич",
            "Габрилян", "31",
            "May", "1966", "T2st");
    app.getContactHelper().createContact(contact, true);
    app.getNavigation().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() +1);


    int max = 0;
    for (ContactData g : after) {
      if (g.getId()> max ) {
        max = g.getId();
      }
    }
    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<>(before),new HashSet<>(after));
  }


}
