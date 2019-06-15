package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactAdd extends TestBase{

  @Test
  public void testAddContact() throws Exception {
    int before = app.getContactHelper().getContactCount(); //считаем контакты до
    app.getContactHelper().createContact(new ContactData("Пётр", "Алексеевич",
            "Габрилян", "31",
            "May", "1966", "T2st"),true);
    app.getNavigation().goToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before +1);
  }


}
