package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;


public class GroupDeletionTest extends TestBase {

  @Test
  public void GroupDeletionTest() throws Exception {

    app.getNavigation().gotoGroup();
    int before = app.getGroupHelper().getGroupCount();
    if (! app.getGroupHelper().isThereaGroup()) {
      app.getGroupHelper().createGroup(new GroupData("T2st", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnGrPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before -1);

  }

}
