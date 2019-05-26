package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;


public class GroupDeletionTest extends TestBase {

  @Test
  public void GroupDeletionTest() throws Exception {

    app.gotoGroup();
    app.selectGroup();
    app.deleteSelectedGroup();
    app.returnGrPage();
  }

}
