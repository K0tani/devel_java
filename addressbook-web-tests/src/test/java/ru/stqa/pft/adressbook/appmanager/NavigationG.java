package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationG extends HelperBase{

  public NavigationG(WebDriver wd) {
    super(wd);
  }

  public void gotoGroup() {
    click(By.linkText("groups"));
  }
}
