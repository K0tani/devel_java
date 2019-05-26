package ru.stqa.pft.adressbook;

public class GroupUpPhones {
  private final String homePhone;
  private final String mobilePhone;
  private final String workPhone;
  private final String fax;

  public GroupUpPhones(String homePhone, String mobilePhone, String workPhone, String fax) {
    this.homePhone = homePhone;
    this.mobilePhone = mobilePhone;
    this.workPhone = workPhone;
    this.fax = fax;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getFax() {
    return fax;
  }
}
