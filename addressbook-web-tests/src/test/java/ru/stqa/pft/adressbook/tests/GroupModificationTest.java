package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

public class GroupModificationTest extends TestBase{

  @Test
  public void testGroupModification() {

    app.getNavigationG().gotoGroup();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillForm(new GroupData("1st", "_23", "_332"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnGrPage();

  }
}
