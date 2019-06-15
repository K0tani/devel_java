package ru.stqa.pft.adressbook.model;

import java.util.Objects;

public class ContactData {
    private int id;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String dateForBday;
    private final String monthForBday;
    private final String yearForBday;
    private String group;

    public ContactData(String firstName, String middleName, String lastName, String dateForBday, String monthForBday, String yearForBday, String group) {
        this.id = Integer.MAX_VALUE;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateForBday = dateForBday;
        this.monthForBday = monthForBday;
        this.yearForBday = yearForBday;
        this.group = group;

    }
    public ContactData(int id, String firstName, String middleName, String lastName, String dateForBday, String monthForBday, String yearForBday, String group) {
        this.id = id;
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

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
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


    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }


}

