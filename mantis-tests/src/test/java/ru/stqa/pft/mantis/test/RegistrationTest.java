package ru.stqa.pft.mantis.test;

import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

    @Test
    public void registrationTest() {
        app.registration().start("user1", "user1@localhost.localdomain");
    }
}
