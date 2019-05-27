package ru.stqa.pft.adressbook.model;

public class ContactUpFio {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickName;

  public ContactUpFio(String firstName, String middleName, String lastName, String nickName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickName = nickName;
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

  public String getNickName() {
    return nickName;
  }
}
