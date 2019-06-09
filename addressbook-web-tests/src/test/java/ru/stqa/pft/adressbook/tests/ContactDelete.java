package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactDelete extends TestBase {

  @Test
  public void testDeleteContact() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Пётр", "Алексеевич",
              "Габрилян", "31",
              "May", "1966", "T2st"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().chooseOk();
    app.getNavigation().goToHomePage();
  }
}

