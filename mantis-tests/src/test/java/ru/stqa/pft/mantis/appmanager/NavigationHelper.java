package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(ApplicationManager app) {
        super(app);
    }


    public void loginPage() {
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    }

    public void manageMenu() {
        wd.get(app.getProperty("web.baseUrl") + "/manage_overview_page.php");
    }
    public void manageUsersPage() {
        wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
    }

    public void editUserPage() {
        manageMenu();
        manageUsersPage();
        wd.findElement(By.xpath("//a[contains(@href, 'manage_user_edit_page.php?user_id=')]")).click();
    }

}
