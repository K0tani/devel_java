package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.GroupData;

public class GroupCreation extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroup();
    app.initCreatGroup();
    app.fillForm(new GroupData("T2st", "3", "2"));
    app.submitFormGroup();
    app.returnGrPage();
  }

}

