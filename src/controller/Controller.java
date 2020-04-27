package controller;

import model.PhoneBook;

import java.io.*;
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
                case 1:
                    phoneBookController.showListPhoneBook();
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
                    System.out.println("Nhap phone number muon xoa");
                    String deletePhoneNumber = scanner.nextLine();
                    removePhoneBook(deletePhoneNumber);
                    break;
                case 5:
                    System.out.println("Nhap phone number hoac ten ban muon tim : ");
                    String searchContent = scanner.nextLine();
                    searchPhoneBooks(searchContent);
                    break;
                case 6:
                    readFile();
                    System.out.println("da doc file");
                    break;
                case 7:
                    writeFile();
                    System.out.println("ghi file thanh cong");
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        } while (choose != 8);
    }

    public boolean addPhoneBook() {
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
        if (isPhoneNumber && isGroup && isFullName && isGender && isAddress && isBirthDay && isEmail) {
            for (PhoneBook phoneBook : phoneBookController.listPhoneBooks) {
                if (phoneBook.getPhoneNunber().equals(phoneNumber)) {
                    System.out.println("Phone number is exists !!");
                    return false;
                }
            }
            PhoneBook phoneBook = new PhoneBook(phoneNumber, group, fullName, gender, address, birthDay, email);
            phoneBookController.listPhoneBooks.add(phoneBook);
            System.out.println("them thanh cong !!");
            return true;
        } else {
            System.out.println("input invalid !!");
            return false;
        }
    }

    public boolean editPhoneBook(String phoneNumber) {
        for (PhoneBook phoneBook : phoneBookController.listPhoneBooks) {
            if (phoneBook.getPhoneNunber().equals(phoneNumber)) {
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
                if (isGroup && isFullName && isGender && isAddress && isBirthDay && isEmail) {
                    phoneBook.setGroup(group);
                    phoneBook.setFullName(fullName);
                    phoneBook.setGender(gender);
                    phoneBook.setAddress(address);
                    phoneBook.setBirthDay(birthDay);
                    phoneBook.setEmail(email);
                    System.out.println("thay doi thanh cong !!");
                    return true;
                } else {
                    System.out.println("sai dinh dang!!");
                    return false;
                }
            }
        }
        System.out.println("Khong tim thay sdt");
        return false;
    }

    public boolean removePhoneBook(String phoneNumber) {
        for (PhoneBook phoneBook : phoneBookController.listPhoneBooks) {
            if (phoneBook.getPhoneNunber().equals(phoneNumber)) {
                phoneBookController.listPhoneBooks.remove(phoneBook);
                System.out.println("Xoa thanh cong");
                return true;
            }
        }
        System.out.println("Khong thanh cong !!! Khong tim thay phone number");
        return false;
    }

    public void searchPhoneBooks(String string) {
        for (PhoneBook phoneBook : phoneBookController.listPhoneBooks) {
            if (phoneBook.getPhoneNunber().indexOf(string) != -1 || phoneBook.getFullName().indexOf(string) != -1) {
                System.out.println(phoneBook.toString());
            }
        }
    }

    public void readFile() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("phone_book_data.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            PhoneBook phoneBook;
            while ((phoneBook = (PhoneBook) objectInputStream.readObject()) != null) {
                phoneBookController.listPhoneBooks.add(phoneBook);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void writeFile() {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("phone_book_data.txt");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (PhoneBook phoneBook : phoneBookController.listPhoneBooks) {
                objectOutputStream.writeObject(phoneBook);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
