package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.GroupData;

public class GroupCreation extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigation().gotoGroup();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("T2st", null, null));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before +1);
  }

}

