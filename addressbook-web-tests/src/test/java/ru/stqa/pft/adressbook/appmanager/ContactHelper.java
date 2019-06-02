package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContact(ContactData contactData,boolean creation) {
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

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElemetPresent(By.name("new_group")));
    }
  }

  public void chooseYearForBday(String yearForBday) {
    click(By.name("byear"));
    wd.findElement(By.name("byear")).sendKeys(yearForBday);
  }

  public void chooseMonthForBday(String monthForBday) {
    click(By.name("bmonth"));
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(monthForBday);
  }

  public void chooseDateForBday(String dateForBday) {
    click(By.name("bday"));
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(dateForBday);
  }

  public void clickOnEnter() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void chooseOk() {
    wd.switchTo().alert().accept();
  }

  public void editContact() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void updateContact() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }
}
