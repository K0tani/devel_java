package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

public class ModifyContact extends TestBase {
  @Test
  public void testDeleteContact() {
    app.getContactHelper().editContact();
    app.getContactHelper().fillContact(new ContactData("Пётр", "Алексеевич", "Габрилян", "Дом", "+88008008888", "Test@mail.ru", "https://www.vk.com", "31", "May", "1966", null), false);
    app.getContactHelper().updateContact();
    app.getNavigation().goToHomePage();
  }
}
