package model;

public class PhoneBook {
    private String phoneNunber;
    private String group;
    private String fullName;
    private String gender;
    private String address;
    private String birthDay;
    private String email;

    public PhoneBook() {
    }

    public PhoneBook(String phoneNunber, String group, String fullName, String gender, String address, String birthDay, String email) {
        this.phoneNunber = phoneNunber;
        this.group = group;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.birthDay = birthDay;
        this.email = email;
    }

    public String getPhoneNunber() {
        return phoneNunber;
    }

    public String getGroup() {
        return group;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNunber(String phoneNunber) {
        this.phoneNunber = phoneNunber;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Phone number : " + this.phoneNunber
                + " ; group : " + this.group
                + " ; full name : " + this.fullName
                + " ; gender : " + this.gender
                + " ; address : " + this.address
                + " ; birth day : " + this.birthDay
                + " ; email : " + this.email;
    }
}
