package ru.stqa.pft.adressbook;

import org.testng.annotations.*;

public class GroupCreation extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroup();
    initCreatGroup();
    fillForm(new GroupData("T2st", "3", "2"));
    submitFormGroup();
    returnGrPage();
  }

}

