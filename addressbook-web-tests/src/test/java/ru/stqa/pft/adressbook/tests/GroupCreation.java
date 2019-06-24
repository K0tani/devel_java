package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SplittableRandom;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreation extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new GroupData().withName("T2st").withHeader("header 2").withFooter("footer 2")});
    list.add(new Object[] {new GroupData().withName("T3st").withHeader("header 3").withFooter("footer 3")});
    list.add(new Object[] {new GroupData().withName("T4st").withHeader("header 4").withFooter("footer 4")});
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) throws Exception {
      app.goTo().groupPage();
      Groups before = app.group().all();
      app.group().create(group);
      Groups after = app.group().all();
      assertThat(after.size(), equalTo(before.size() +1));
      assertThat(after, equalTo(before.withAdded(group.withId(after.stream()
              .mapToInt(g -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("T2st'");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));

  }

}

