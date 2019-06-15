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
    int before = app.getContactHelper().getContactCount(); //считаем контакты до
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().chooseOk();
    app.getNavigation().clickOnPageHome();
    int after = app.getContactHelper().getContactCount(); //считаем контакты после
    Assert.assertEquals(after, before -1);
  }
}

