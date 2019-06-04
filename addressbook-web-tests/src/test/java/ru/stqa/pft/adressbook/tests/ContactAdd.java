package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactAdd extends TestBase{

  @Test
  public void testAddContact() throws Exception {
    app.getContactHelper().createContact(new ContactData("Пётр", "Алексеевич",
            "Габрилян", "31",
            "May", "1966", null),true);
    app.getNavigation().goToHomePage();
  }

}
