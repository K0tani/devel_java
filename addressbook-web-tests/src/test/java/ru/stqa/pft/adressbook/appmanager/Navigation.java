package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navigation extends HelperBase{

  public Navigation(WebDriver wd) {
    super(wd);
  }

  public void gotoGroup() {
    if(isElemetPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElemetPresent (By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void goToHomePage() {
    if (isElemetPresent(By.id("maintable"))) {
      return;
    }

  }

  public void clickOnPageHome() {
    wd.findElement(By.xpath("//a[.='home']\n")).click();
  }


}
