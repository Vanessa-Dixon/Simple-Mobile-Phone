package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    public static MobilePhone mobilePhone = new MobilePhone("555 555 5555");

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printAction();
        while(!quit) {
            System.out.println("\n Enter action: (6 to show available action)");
            int action = scan.nextInt();
            scan.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printcontacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printAction();
                    break;

            }
        }

    }

    private static void addNewContact() {
        System.out.println("Enter new contact name:");
        String name = scan.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scan.nextLine();
        Contacts newContact = Contacts.createContact(name, phone);
        if(mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: name = " + name + ", phone = " + phone);
        }
        else{
            System.out.println("Cannot add, " + name + " already on file");
        }
     }

     private static void updateContact() {
         System.out.println("Enter exist contact name: ");
         String name = scan.nextLine();
         Contacts existingContactRecord = mobilePhone.queryContact(name);
         if(existingContactRecord == null) {
             System.out.println("Contact not found");
             return;
         }
         System.out.println("Enter new contact name: ");
         String newName = scan. nextLine();
         System.out.println("Enter new contact phone number: ");
         String newNumber = scan.nextLine();
         Contacts newContact = Contacts.createContact(newName, newNumber);
         mobilePhone.updateContact(existingContactRecord, newContact);
         if(mobilePhone.updateContact(existingContactRecord, newContact)) {
             System.out.println("Successfully updated record");
         }
         else {
             System.out.println("Error updating record");
         }
     }

    private static void removeContact() {
        System.out.println("Enter exist contact name: ");
        String name = scan.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        if(mobilePhone.removeContact(existingContactRecord)) {
            System.out.println("Successfully deleted");
        }
        else {
            System.out.println("Error deleting contact");
        }

    }

    private static void queryContact() {
        System.out.println("Enter exist contact name: ");
        String name = scan.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getName() + " Phone number is " + existingContactRecord.getPhoneNumber());

    }


    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printAction() {
        System.out.println("\nAvailable actions: \npress");
        System.out.println("0 - to shutdown\n" +
                           "1 - print contacts\n" +
                            "2 - to add a new contacts\n" +
                           "3 - to update existing an existing contact\n" +
                           "4 - to remove an existing contact\n" +
                           "5 -query if an existing contact exists\n" +
                           "6 - to print a list of available actions.");
        System.out.println("Choose your action: ");

    }


}
