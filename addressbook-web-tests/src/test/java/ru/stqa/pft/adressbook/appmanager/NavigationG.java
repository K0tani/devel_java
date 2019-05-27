package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationG {
  private WebDriver wd;

  public NavigationG(WebDriver wd) {
    this.wd = wd;
  }

  public void gotoGroup() {
    wd.findElement(By.linkText("groups")).click();
  }
}
