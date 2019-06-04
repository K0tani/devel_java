package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactModify extends TestBase {
  @Test
  public void testDeleteContact() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Пётр", "Алексеевич",
              "Габрилян", "31",
              "May", "1966", "T2st"), true);
    }
    app.getContactHelper().editContact();
    app.getContactHelper().fillContact(new ContactData("Пётр", "Алексеевич",
            "Габрилян", "31",
            "May", "1966", null), false);
    app.getContactHelper().updateContact();
    app.getNavigation().goToHomePage();
  }
}
