package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UserData;

public class ActionHelper extends HelperBase {

    public ActionHelper(ApplicationManager app) {
        super(app);
    }


    public void loginAsAdmin() {
        type(By.name("username"), "administrator");
        click(By.xpath("//input[@type='submit']"));
        type(By.name("password"), "root");
        click(By.xpath("//input[@type='submit']"));
    }

    public void loginAsUser(String username, String password) {
        type(By.name("username"), username);
        click(By.xpath("//input[@type='submit']"));
        type(By.name("password"), password);
        click(By.xpath("//input[@type='submit']"));
    }

    public void resetPassword() {
        click(By.xpath("//input[@value='Сбросить пароль']"));
    }

    public void choiseUser(UserData account) {
        wd.get(app.getProperty("web.baseUrl") +"/manage_user_page.php");
        wd.findElement(By.xpath("//a[contains(@href, 'manage_user_edit_page.php?user_id="+ account.getId()+"')]")).click();
    }
}
