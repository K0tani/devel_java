package ru.stqa.pft.adressbook;

import org.testng.annotations.Test;


public class GroupDeletionTest extends TestBase{

  @Test
  public void GroupDeletionTest() throws Exception {

    gotoGroup();
    selectGroup();
    deleteSelectedGroup();
    returnGrPage();
  }

}
