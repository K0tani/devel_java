package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navigation extends HelperBase{

  public Navigation(WebDriver wd) {
    super(wd);
  }

  public void gotoGroup() {
    click(By.linkText("groups"));
  }

  public void goBackHomeFromContactPage() {
    wd.findElement(By.linkText("home")).click();
  }

  public void addNewContact() {
    wd.findElement(By.linkText("add new")).click();
  }
}
