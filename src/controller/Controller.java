package controller;

import model.PhoneBook;

import java.util.Scanner;

public class Controller {
    Validate validate = new Validate();
    Scanner scanner = new Scanner(System.in);
    PhoneBookController phoneBookController = new PhoneBookController();
    View view = new View();
    public void controller() {
        int choose;

        do {
            view.showMenu();
            choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1:phoneBookController.showListPhoneBook();
                    break;
                case 2:
                    addPhoneBook();
                    break;
                case 3:
                    System.out.println("Enter phone number : ");
                    String phoneNumber = scanner.nextLine();
                    editPhoneBook(phoneNumber);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
            }

        } while (choose != 8);
    }
    public boolean addPhoneBook(){
        System.out.println("Enter Phone number ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter group ");
        String group = scanner.nextLine();
        System.out.println("Enter full name ");
        String fullName = scanner.nextLine();
        System.out.println("Enter gender");
        String gender = scanner.nextLine();
        System.out.println("Enter address");
        String address = scanner.nextLine();
        System.out.println("Enter birth day");
        String birthDay = scanner.nextLine();
        System.out.println("Enter email");
        String email = scanner.nextLine();

        boolean isPhoneNumber = validate.isValidate(validate.PHONE_NUMBER_REGEX, phoneNumber);
        boolean isGroup = validate.isValidate(validate.GROUP_REGEX, group);
        boolean isFullName = validate.isValidate(validate.FULL_NAME_REGEX, fullName);
        boolean isGender = validate.isValidate(validate.GENDER_REGEX, gender);
        boolean isAddress = validate.isValidate(validate.ADDRESS_REGEX, address);
        boolean isBirthDay = validate.isValidate(validate.BIRTH_DAY_REGEX, birthDay);
        boolean isEmail = validate.isValidate(validate.EMAIL_REGEX, email);
        if (isPhoneNumber && isGroup && isFullName && isGender && isAddress && isBirthDay && isEmail){
            for(PhoneBook phoneBook : phoneBookController.listPhoneBooks){
                if (phoneBook.getPhoneNunber().equals(phoneNumber)){
                    System.out.println("Phone number is exists !!");
                    return false;
                }
            }
            PhoneBook phoneBook = new PhoneBook(phoneNumber, group, fullName, gender, address, birthDay, email);
            phoneBookController.listPhoneBooks.add(phoneBook);
            System.out.println("them thanh cong !!");
            return true;
        }else {
            System.out.println("input invalid !!");
            return false;
        }
    }

    public boolean editPhoneBook(String phoneNumber){
        for(PhoneBook phoneBook : phoneBookController.listPhoneBooks){
            if(phoneBook.getPhoneNunber().equals(phoneNumber)){
                System.out.println("Enter group ");
                String group = scanner.nextLine();
                System.out.println("Enter full name ");
                String fullName = scanner.nextLine();
                System.out.println("Enter gender");
                String gender = scanner.nextLine();
                System.out.println("Enter address");
                String address = scanner.nextLine();
                System.out.println("Enter birth day");
                String birthDay = scanner.nextLine();
                System.out.println("Enter email");
                String email = scanner.nextLine();
                boolean isGroup = validate.isValidate(validate.GROUP_REGEX, group);
                boolean isFullName = validate.isValidate(validate.FULL_NAME_REGEX, fullName);
                boolean isGender = validate.isValidate(validate.GENDER_REGEX, gender);
                boolean isAddress = validate.isValidate(validate.ADDRESS_REGEX, address);
                boolean isBirthDay = validate.isValidate(validate.BIRTH_DAY_REGEX, birthDay);
                boolean isEmail = validate.isValidate(validate.EMAIL_REGEX, email);
                if (isGroup && isFullName && isGender && isAddress && isBirthDay && isEmail){
                    phoneBook.setGroup(group);
                    phoneBook.setFullName(fullName);
                    phoneBook.setGender(gender);
                    phoneBook.setAddress(address);
                    phoneBook.setBirthDay(birthDay);
                    phoneBook.setEmail(email);
                    System.out.println("thay doi thanh cong !!");
                    return true;
                }
                else {
                    System.out.println("sai dinh dang!!");
                    return false;
                }
            }
        }
        System.out.println("Khong tim thay sdt");
        return false;
    }
}
