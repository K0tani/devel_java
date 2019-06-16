package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContact(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    chooseDateForBday(contactData.getDateForBday());
    chooseMonthForBday(contactData.getMonthForBday());
    chooseYearForBday(contactData.getYearForBday());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElemetPresent(By.name("new_group")));
    }
  }

  public boolean isThereAContact() {
    return isElemetPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void addNewContact() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void create(ContactData contact, boolean creation) {
    addNewContact();
    fillContact(contact, creation);
    clickOnEnter();
    goToHomePage();
  }
  public void goToHomePage() {
    wd.findElement(By.linkText("home")).click();
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

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void modify( ContactData contact) {
    editContactById(contact.getId());
    fillContact(contact, false);
    updateContact();
    goToHomePage();
  }

  public void editContactById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
  }


  public void deleteButtonPress() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteButtonPress();
    chooseOk();
    goToHomePage();
  }

  public void chooseOk() {
    wd.switchTo().alert().accept();
  }


  public void updateContact() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      String firstName = element.findElements(By.tagName("td")).get(2).getText();
      String lastName = element.findElements(By.tagName("td")).get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstName(firstName).withMiddleName(null).withLastName(lastName).withDateForBday(null)
              .withtMonthForBday(null).withYearForBday(null).withGroup(null));
    }
    return contacts;
  }


}
