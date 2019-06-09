package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.adressbook.model.GroupData;

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

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void createGroup(GroupData group) {
    initCreatGroup();
    fillForm(group);
    submitFormGroup();
    returnGrPage();
  }

  public boolean isThereaGroup() {
    return isElemetPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
     return wd.findElements(By.name("selected[]")).size();
  }
}
