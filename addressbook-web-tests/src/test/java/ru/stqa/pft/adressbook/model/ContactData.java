package ru.stqa.pft.adressbook.model;

public class ContactData {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String dateForBday;
    private final String monthForBday;
    private final String yearForBday;
    private String group;


    public ContactData(String firstName, String middleName, String lastName, String dateForBday, String monthForBday, String yearForBday, String group) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
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

