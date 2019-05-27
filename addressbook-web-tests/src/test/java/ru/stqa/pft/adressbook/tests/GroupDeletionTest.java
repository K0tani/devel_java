package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;


public class GroupDeletionTest extends TestBase {

  @Test
  public void GroupDeletionTest() throws Exception {

    app.gotoGroup();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnGrPage();
  }

}
