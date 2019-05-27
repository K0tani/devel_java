package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.adressbook.model.GroupData;

public class GroupHelper {
  WebDriver wd;

  public void returnGrPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  public void submitFormGroup() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  public void initCreatGroup() {
    wd.findElement(By.name("new")).click();
  }

  public void deleteSelectedGroup() {
    wd.findElement(By.xpath("(//input[@name='delete'])[2]")).click();
  }

  public void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }
}
