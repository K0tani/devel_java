package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.List;

public class ContactModify extends TestBase {
  @Test
  public void contactModify() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Пётр", "Алексеевич",
              "Габрилян", "31",
              "May", "1966", "T2st"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().editContact(before.size() -2);
    app.getContactHelper().fillContact(new ContactData("Пётр", "Алексеевич",
            "Габрилян", "31",
            "May", "1966", null), false);
    app.getContactHelper().updateContact();
    app.getNavigation().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());



  }
}
