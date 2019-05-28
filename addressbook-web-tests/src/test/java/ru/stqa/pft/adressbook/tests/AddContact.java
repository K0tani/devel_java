package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.*;

public class AddContact extends TestBase{

  @Test
  public void testAddContact() throws Exception {
    app.getContactHelper().addNewContact();
    app.getContactHelper().fillContact();
    app.getContactHelper().clickOnEnter();
    app.getContactHelper().goBackHome();
  }

}
