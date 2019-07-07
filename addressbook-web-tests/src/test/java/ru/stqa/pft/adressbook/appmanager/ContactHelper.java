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
    attach(By.name("photo"),contactData.getPhoto());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHome());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWork());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    selectListValue(By.name("bday"), contactData.getDateForBday());
    selectListValue(By.name("bmonth"), contactData.getMonthForBday());
    type(By.name("byear"), contactData.getYearForBday());

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
    contactCache = null;
    goToHomePage();
  }

  public void goToHomePage() {
    if (isElemetPresent (By.linkText("home page")))
      click(By.linkText("home page"));
    else
      click(By.linkText("home"));
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

  public void modify(ContactData contact,boolean creation) {
    editContactById(contact.getId());
    fillContact(contact, creation);
    updateContact();
    contactCache = null;
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
    contactCache = null;
    chooseOk();
    goToHomePage();
  }

  public void chooseOk() {
    wd.switchTo().alert().accept();
  }


  public void updateContact() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
    for(WebElement element: elements){
      String lastname = element.findElement(By.xpath("td[2]")).getText();
      String firstname = element.findElement(By.xpath("td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname));
    }
    return new Contacts(contactCache);
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Set<ContactData> allBasicInfo(){
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for(WebElement row: rows){
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();
      contacts.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname).withAddress(address).withAllPhones(allPhones).withAllEmails(allEmails));
    }
    return contacts;
  }


  public ContactData basicInfoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");

    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstname).withMiddleName(null).withLastName(lastname).withAddress(address)
            .withHome(home).withMobile(mobile).withWork(work).withEmail(email).withEmail2(email2).withEmail3(email3);
  }



  public void initContactModificationById(int id) {
    //wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }
}
