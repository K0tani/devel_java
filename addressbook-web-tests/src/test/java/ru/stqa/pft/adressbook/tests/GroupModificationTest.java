package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

public class GroupModificationTest extends TestBase{

  @Test
  public void testGroupModification() {

    app.getNavigation().gotoGroup();
    if (! app.getGroupHelper().isThereaGroup()) {
      app.getGroupHelper().createGroup(new GroupData("T2st", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillForm(new GroupData("1st", "24", "_332"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnGrPage();

  }
}
