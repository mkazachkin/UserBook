package model;

public abstract class UserDataA {
    private String firstName;
    private String midName;
    private String lastName;
    private String birthDate;
    private Long phoneNumber;
    private UserSex sex;

    public UserDataA() {
        this.firstName = null;
        this.midName = null;
        this.lastName = null;
        this.birthDate = null;
        this.phoneNumber = null;
        this.sex = UserSex.NO_DATA;
    }
    public UserDataA (String firstName, String midName, String lastName,
                     String birthDate, Long phoneNumber, UserSex sex) {
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserSex getSex() {
        return sex;
    }

    public void setSex(UserSex sex) {
        this.sex = sex;
    }
}
