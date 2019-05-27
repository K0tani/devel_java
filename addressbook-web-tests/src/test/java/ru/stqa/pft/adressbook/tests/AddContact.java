package ru.stqa.pft.adressbook.tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.adressbook.model.ContactUpBday;
import ru.stqa.pft.adressbook.model.ContactUpEmail;
import ru.stqa.pft.adressbook.model.ContactUpFio;
import ru.stqa.pft.adressbook.model.ContactUpPhones;

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
    fillFormFio(new ContactUpFio("Алексей", "Григорович", "Абрелян", "Котани"));
    fillFormPhones(new ContactUpPhones("+79993459988", "99994569876", "89560987766", "45678904444"));
    fillFormEmail(new ContactUpEmail("pokrt@mail.ru", "mai@mail.com", "wulik@rumlber.ru"));
    fillFormBirthday(new ContactUpBday("14", "February", "1991"));
    submitForm();
    goHome();
  }


  private void newContact() {
    wd.findElement(By.linkText("add new")).click();
  }

  private void fillFormFio(ContactUpFio contactUpFio) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contactUpFio.getFirstName());
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(contactUpFio.getMiddleName());
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactUpFio.getLastName());
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(contactUpFio.getNickName());
  }

  private void fillFormPhones(ContactUpPhones contactUpPhones) {
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(contactUpPhones.getHomePhone());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(contactUpPhones.getMobilePhone());
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys(contactUpPhones.getWorkPhone());
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys(contactUpPhones.getFax());
  }

  private void fillFormEmail(ContactUpEmail contactUpEmail) {
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(contactUpEmail.getFirstEmail());
    wd.findElement(By.name("email2")).clear();
    wd.findElement(By.name("email2")).sendKeys(contactUpEmail.getSecondEmail());
    wd.findElement(By.name("email3")).clear();
    wd.findElement(By.name("email3")).sendKeys(contactUpEmail.getThirdEmail());
  }

  private void fillFormBirthday(ContactUpBday contactUpBday) {
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactUpBday.getbDay());
    wd.findElement(By.name("bday")).click();
    wd.findElement(By.name("bmonth")).click();
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactUpBday.getbMonth());
    wd.findElement(By.name("bmonth")).click();
    wd.findElement(By.name("homepage")).click();
    wd.findElement(By.name("byear")).click();
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys(contactUpBday.getbYear());
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
