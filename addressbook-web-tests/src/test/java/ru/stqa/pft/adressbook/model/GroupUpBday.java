package ru.stqa.pft.adressbook.model;

public class GroupUpBday {
  private final String bDay;
  private final String bMonth;
  private final String bYear;

  public GroupUpBday(String bDay, String bMonth, String bYear) {
    this.bDay = bDay;
    this.bMonth = bMonth;
    this.bYear = bYear;
  }

  public String getbDay() {
    return bDay;
  }

  public String getbMonth() {
    return bMonth;
  }

  public String getbYear() {
    return bYear;
  }
}
