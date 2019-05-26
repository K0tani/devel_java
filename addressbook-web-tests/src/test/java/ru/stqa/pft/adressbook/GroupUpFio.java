package ru.stqa.pft.adressbook;

public class GroupUpFio {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickName;

  public GroupUpFio(String firstName, String middleName, String lastName, String nickName) {
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
