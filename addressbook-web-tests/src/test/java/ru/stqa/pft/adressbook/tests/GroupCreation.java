package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.GroupData;

public class GroupCreation extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigation().gotoGroup();
    app.getGroupHelper().createGroup(new GroupData("T2st", null, null));
  }

}

