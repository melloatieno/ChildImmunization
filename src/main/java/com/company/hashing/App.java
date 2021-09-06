package com.company.hashing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int counter = 0;
        while (counter < 10) {
            System.out.println("Add Child");
            Scanner input = new Scanner(System.in);
            Child child = new Child();
            System.out.println("NAME:");
            child.setName(input.nextLine());
            System.out.println("DoB:");
            String dateOfBirth = input.nextLine();
            Date dob = simpleDateFormat.parse(dateOfBirth);
            System.out.println("SELECT GENDER: ");
            System.out.println("1. MALE");
            System.out.println("2. FEMALE");
            child.setGender(Gender.values()[input.nextInt() - 1]);
            input.nextLine();
            System.out.println("IMMUNIZATION:");
            child.setImmuzation(input.nextLine());
            System.out.println("Dose:");
            child.setDose(input.nextInt());
            input.nextLine();
            System.out.println("MOTHER:");
            child.setMother_name(input.nextLine());

            ChildController childController = new ChildController();
            childController.addChild(child);

           for (Child childList : childController.listChild()) {
                System.out.println(childList.getId() + ". " + childList.getName() + " Born " + childList.getDob()
                        + " was given " + childList.getDose() + " dose of " + childList.getImmuzation());
            }
            counter++;
        }
    }
}
