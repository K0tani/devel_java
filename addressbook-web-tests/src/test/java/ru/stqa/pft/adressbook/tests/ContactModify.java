package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactModify extends TestBase {
  @Test
  public void contactModify() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Пётр", "Алексеевич",
              "Габрилян", "31",
              "May", "1966", "T2st"), true);
    }
    int before = app.getContactHelper().getContactCount(); //считаем контакты до
    app.getContactHelper().editContact(before -1);
    app.getContactHelper().fillContact(new ContactData("Пётр", "Алексеевич",
            "Габрилян", "31",
            "May", "1966", null), false);
    app.getContactHelper().updateContact();
    app.getNavigation().goToHomePage();
    int after = app.getContactHelper().getContactCount(); //считаем контакты после
    Assert.assertEquals(after, before);



  }
}
