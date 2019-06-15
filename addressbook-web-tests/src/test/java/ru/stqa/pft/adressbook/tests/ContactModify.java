package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.*;

public class ContactModify extends TestBase {
  @Test(enabled = false)
  public void contactModify() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Пётр", "Алексеевич",
              "Габрилян", "31",
              "May", "1966", "T2st"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().editContact(before.size() -1);
    ContactData contact = new ContactData(before.get(before.size() -1).getId(),
            "Пётр",
            "Алексеевич",
            "Габрилян",
            "31",
            "May",
            "1966",
            null);
    app.getContactHelper().fillContact(contact, false);
    app.getContactHelper().updateContact();
    app.goTo().goToHomePage();

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1,c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);



  }
}
