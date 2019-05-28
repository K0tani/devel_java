package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactHelper {
  WebDriver wd;

  public ContactHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void fillContact() {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys("Алексей");
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys("Григорович");
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys("Абрелян");
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys("Котани");
    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys("Титле");
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys("Компания");
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys("Адрес 1 1 кв 231");
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys("+79993459988");
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys("99994569876");
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys("89560987766");
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys("45678904444");
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys("pokrt@mail.ru");
    wd.findElement(By.name("email2")).clear();
    wd.findElement(By.name("email2")).sendKeys("mai@mail.com");
    wd.findElement(By.name("email3")).clear();
    wd.findElement(By.name("email3")).sendKeys("wulik@rumlber.ru");
    wd.findElement(By.name("homepage")).clear();
    wd.findElement(By.name("homepage")).sendKeys("https://www.reddit.com");
    wd.findElement(By.name("bday")).click();
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText("14");
    wd.findElement(By.name("bday")).click();
    wd.findElement(By.name("bmonth")).click();
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText("February");
    wd.findElement(By.name("bmonth")).click();
    wd.findElement(By.name("homepage")).click();
    wd.findElement(By.name("byear")).click();
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys("1991");
    wd.findElement(By.name("aday")).click();
    new Select(wd.findElement(By.name("aday"))).selectByVisibleText("19");
    wd.findElement(By.name("amonth")).click();
    new Select(wd.findElement(By.name("amonth"))).selectByVisibleText("January");
    wd.findElement(By.name("amonth")).click();
    wd.findElement(By.name("ayear")).click();
    wd.findElement(By.name("ayear")).clear();
    wd.findElement(By.name("ayear")).sendKeys("1983");
    wd.findElement(By.name("new_group")).click();
    wd.findElement(By.name("address2")).click();
    wd.findElement(By.name("address2")).clear();
    wd.findElement(By.name("address2")).sendKeys("Flhtcc");
    wd.findElement(By.name("phone2")).click();
    wd.findElement(By.name("phone2")).clear();
    wd.findElement(By.name("phone2")).sendKeys("Хоме");
    wd.findElement(By.name("notes")).clear();
    wd.findElement(By.name("notes")).sendKeys("Нотес");
  }

  public void clickOnEnter() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void goBackHome() {
    wd.findElement(By.linkText("home")).click();
  }

  public void addNewContact() {
    wd.findElement(By.linkText("add new")).click();
  }
}
