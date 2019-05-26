package ru.stqa.pft.adressbook;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddContact {
  private WebDriver wd;


  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.get("http://localhost/addressbook/");
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  @Test
  public void testAddContact() throws Exception {
    newContact();
    fillFormFio(new GroupUpFio("Алексей", "Григорович", "Абрелян", "Котани"));
    fillFormPhones(new GroupUpPhones("+79993459988", "99994569876", "89560987766", "45678904444"));
    fillFormEmail(new GroupUpEmail("pokrt@mail.ru", "mai@mail.com", "wulik@rumlber.ru"));
    fillFormBirthday(new GroupUpBday("14", "February", "1991"));
    submitForm();
    goHome();
  }


  private void newContact() {
    wd.findElement(By.linkText("add new")).click();
  }

  private void fillFormFio(GroupUpFio groupUpFio) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(groupUpFio.getFirstName());
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(groupUpFio.getMiddleName());
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(groupUpFio.getLastName());
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(groupUpFio.getNickName());
  }

  private void fillFormPhones(GroupUpPhones groupUpPhones) {
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(groupUpPhones.getHomePhone());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(groupUpPhones.getMobilePhone());
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys(groupUpPhones.getWorkPhone());
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys(groupUpPhones.getFax());
  }

  private void fillFormEmail(GroupUpEmail groupUpEmail) {
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(groupUpEmail.getFirstEmail());
    wd.findElement(By.name("email2")).clear();
    wd.findElement(By.name("email2")).sendKeys(groupUpEmail.getSecondEmail());
    wd.findElement(By.name("email3")).clear();
    wd.findElement(By.name("email3")).sendKeys(groupUpEmail.getThirdEmail());
  }

  private void fillFormBirthday(GroupUpBday groupUpBday) {
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(groupUpBday.getbDay());
    wd.findElement(By.name("bday")).click();
    wd.findElement(By.name("bmonth")).click();
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(groupUpBday.getbMonth());
    wd.findElement(By.name("bmonth")).click();
    wd.findElement(By.name("homepage")).click();
    wd.findElement(By.name("byear")).click();
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys(groupUpBday.getbYear());
  }

  private void submitForm() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    wd.findElement(By.linkText("add new")).click();
  }

  private void goHome() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    wd.findElement(By.linkText("home page")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }


}
