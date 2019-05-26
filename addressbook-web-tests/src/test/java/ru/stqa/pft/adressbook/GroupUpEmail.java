package ru.stqa.pft.adressbook;

public class GroupUpEmail {
  private final String firstEmail;
  private final String secondEmail;
  private final String thirdEmail;

  public GroupUpEmail(String firstEmail, String secondEmail, String thirdEmail) {
    this.firstEmail = firstEmail;
    this.secondEmail = secondEmail;
    this.thirdEmail = thirdEmail;
  }

  public String getFirstEmail() {
    return firstEmail;
  }

  public String getSecondEmail() {
    return secondEmail;
  }

  public String getThirdEmail() {
    return thirdEmail;
  }
}
