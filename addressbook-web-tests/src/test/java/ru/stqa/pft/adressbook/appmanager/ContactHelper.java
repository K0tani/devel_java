package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContact(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddRess());
    type(By.name("home"), contactData.getHomeMobile());
    type(By.name("email"), contactData.getEmailFill());
    type(By.name("homepage"), contactData.getHomePage());
    chooseDateForBday(contactData.getDateForBday());
    chooseMonthForBday(contactData.getMonthForBday());
    chooseYearForBday(contactData.getYearForBday());
  }

  public void chooseYearForBday(String yearForBday) {
    wd.findElement(By.name("byear")).click();
    wd.findElement(By.name("byear")).sendKeys(yearForBday);
  }

  public void chooseMonthForBday(String monthForBday) {
    wd.findElement(By.name("bmonth")).click();
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(monthForBday);
  }

  public void chooseDateForBday(String dateForBday) {
    wd.findElement(By.name("bday")).click();
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(dateForBday);
  }

  public void clickOnEnter() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

}
