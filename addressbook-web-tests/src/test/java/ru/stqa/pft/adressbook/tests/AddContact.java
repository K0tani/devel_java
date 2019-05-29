package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.ContactData;

public class AddContact extends TestBase{

  @Test
  public void testAddContact() throws Exception {
    app.getNavigation().addNewContact();
    app.getContactHelper().fillContact(new ContactData("Алексей", "Григорович", "Абрелян", "Улица", "+79993459988", "pokrt@mail.ru", "https://www.reddit.com", "14", "February", "1991"));
    app.getContactHelper().clickOnEnter();
    app.getNavigation().goBackHomeFromContactPage();
  }

}
