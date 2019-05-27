package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionLogin {
  private WebDriver wd;

  public SessionLogin(WebDriver wd) {

    this.wd = wd;
  }
  public void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.id("LoginForm")).click();
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }
}
