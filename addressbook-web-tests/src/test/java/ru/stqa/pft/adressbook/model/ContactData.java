package ru.stqa.pft.adressbook.model;

public class ContactData {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String addRess;
    private final String homeMobile;
    private final String emailFill;
    private final String homePage;
    private final String dateForBday;
    private final String monthForBday;
    private final String yearForBday;
    private String group;

    public ContactData(String firstName, String middleName, String lastName, String addRess, String homeMobile, String emailFill, String homePage, String dateForBday, String monthForBday, String yearForBday, String group) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.addRess = addRess;
        this.homeMobile = homeMobile;
        this.emailFill = emailFill;
        this.homePage = homePage;
        this.dateForBday = dateForBday;
        this.monthForBday = monthForBday;
        this.yearForBday = yearForBday;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddRess() {
        return addRess;
    }

    public String getHomeMobile() {
        return homeMobile;
    }

    public String getEmailFill() {
        return emailFill;
    }

    public String getHomePage() {
        return homePage;
    }

    public String getDateForBday() {
        return dateForBday;
    }

    public String getMonthForBday() {
        return monthForBday;
    }

    public String getYearForBday() {
        return yearForBday;
    }

    public String getGroup() {
        return group;
    }
}

