package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import java.util.List;

public class GroupHelper extends HelperBase{

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnGrPage() {
    click(By.linkText("group page"));
  }

  public void submitFormGroup() {
    click(By.name("submit"));
  }

  public void fillForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initCreatGroup() {
    click(By.name("new"));
  }

  public void deleteSelectedGroup() {
    click(By.xpath("(//input[@name='delete'])[2]"));
  }

  public void selectGroupById(int id ) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public boolean isThereaGroup() {
    return isElemetPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void create(GroupData group) {
    initCreatGroup();
    fillForm(group);
    submitFormGroup();
    groupCache = null;
    returnGrPage();
  }

  public void modify(GroupData group) {
   selectGroupById(group.getId());
   initGroupModification();
   fillForm(group);
   submitGroupModification();
    groupCache = null;
   returnGrPage();
  }

  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectedGroup();
    groupCache = null;
    returnGrPage();
  }

  private Groups groupCache = null;

  public Groups all() {
    if (groupCache!= null) {
      return new Groups(groupCache);
    }
      groupCache = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupCache.add(new GroupData().withId(id).withName(name).withHeader(null).withFooter(null));
    }
    return new Groups(groupCache);
  }


}
