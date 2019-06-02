package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;


public class GroupDeletionTest extends TestBase {

  @Test
  public void GroupDeletionTest() throws Exception {

    app.getNavigation().gotoGroup();
    if (! app.getGroupHelper().isThereaGroup()) {
      app.getGroupHelper().createGroup(new GroupData("T2st", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnGrPage();
  }

}
