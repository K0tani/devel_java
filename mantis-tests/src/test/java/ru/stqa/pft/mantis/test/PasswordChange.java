package ru.stqa.pft.mantis.test;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;


public class PasswordChange extends TestBase {


    @Test
    public void testPasswordChangeByAdministrator() throws MessagingException, IOException {
        Users users = app.db().users();
        UserData selectedUser = users.iterator().next();
        app.goTo().loginPage();
        app.doAction().loginAsAdmin();
        app.goTo().editUserPage();
        app.doAction().choiseUser(selectedUser);
        app.doAction().resetPassword();
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String confirmationLink = app.mail().findConfirmationLink(mailMessages, selectedUser.getEmail());
        String newpassword = "newpassword";
        app.registration().finish(confirmationLink, newpassword);
        assertTrue(app.newSession().login(selectedUser.getUsername(), newpassword));

    }

}