package ru.stqa.pft.adressbook.model;

import java.io.File;
import java.util.Objects;
import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("contact")
public class ContactData {
    @XStreamOmitField
    private int id = Integer.MAX_VALUE;
    @Expose
    private String firstName;
    @Expose
    private String middleName;
    @Expose
    private String lastName;
    @Expose
    private String dateForBday;
    @Expose
    private String monthForBday;
    @Expose
    private String yearForBday;
    @Expose
    private String group;
    @Expose
    private String home;
    @Expose
    private String mobile;
    @Expose
    private String work;
    @Expose
    private String email;
    @Expose
    private String email2;
    @Expose
    private String email3;
    private String allPhones;
    @Expose
    private String address;
    private String allEmails;
    @Expose
    private File photo;

    public File getPhoto() {
        return photo;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;

    }

    public String getEmail2() {
        return email2;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;

    }

    public String getEmail3() {
        return email3;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }



    public String getAddress() {
        return address;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public int getId() {
        return id;
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

    public String getAllPhones() {
        return allPhones;
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

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWork() {
        return work;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withDateForBday(String dateForBday) {
        this.dateForBday = dateForBday;
        return this;
    }

    public ContactData withMonthForBday(String monthForBday) {
        this.monthForBday = monthForBday;
        return this;
    }

    public ContactData withYearForBday(String yearForBday) {
        this.yearForBday = yearForBday;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withHome(String home) {
        this.home = home;
        return this;
    }

    public ContactData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactData withWork(String work) {
        this.work = work;
        return this;
    }


    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", home='" + home + '\'' +
                ", mobile='" + mobile + '\'' +
                ", work='" + work + '\'' +
                ", email='" + email + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                ", group='" + group + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }


}

