package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.db().groups().size()== 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test 0"));
    }
  }

  @Test
  public void GroupDeletionTest() throws Exception {
    Groups before = app.db().groups();
    GroupData deleteGroup = before.iterator().next();
    app.goTo().groupPage();
    app.group().delete(deleteGroup);
    assertThat(app.group().count(), equalTo(before.size() - 1));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(deleteGroup)));
  }


}
