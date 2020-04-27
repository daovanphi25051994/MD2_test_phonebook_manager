package controller;

import model.PhoneBook;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookController {
    ArrayList<PhoneBook> listPhoneBooks = new ArrayList<>();
    public boolean addPhoneBook(PhoneBook phoneBook){
        if (isExists(phoneBook)){
            return false;
        }
        listPhoneBooks.add(phoneBook);
        return true;
    }
    public void showListPhoneBook(){
        for (PhoneBook phoneBook : listPhoneBooks){
            System.out.println(phoneBook.toString());
        }
    }
    public void editByPhoneNumber(String phoneNumber){
        Scanner scanner = new Scanner(System.in);
        for (PhoneBook phoneBook : listPhoneBooks){
            if (phoneBook.getPhoneNunber().equals(phoneNumber)){
                System.out.println("Group : ");
                phoneBook.setGroup(scanner.nextLine());
                System.out.println("Full name : ");
                phoneBook.setFullName(scanner.nextLine());
                System.out.println("Gender : ");
                phoneBook.setGender(scanner.nextLine());
                System.out.println("Address : ");
                phoneBook.setAddress(scanner.nextLine());
                System.out.println("Birth day : ");
                phoneBook.setBirthDay(scanner.nextLine());
                System.out.println("Email : ");
                phoneBook.setEmail(scanner.nextLine());
                return;
            }
        }
    }

    public boolean isExists(PhoneBook phoneBook){
        for(PhoneBook phoneBook1 : listPhoneBooks){
            if (phoneBook1.getPhoneNunber().equals(phoneBook.getPhoneNunber())){
                return true;
            }
        }
        return false;
    }
}
