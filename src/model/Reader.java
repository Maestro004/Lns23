package model;

import enums.Gender;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Reader {
    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private Gender gender;

    public Reader(Long id, String fullName, String email, String phoneNumber, Gender gender) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
    public Reader(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName() {
        boolean nameIsTrue = true;
        while (nameIsTrue) {
            System.out.println("Напишите полное имя читателя: ");
            try {
                String name =  new Scanner(System.in).nextLine();
                if (name.matches(".*\\d.*")) {
                    throw new InputMismatchException("Имя должно состоять из букв!");
                }
                this.fullName=name;
                nameIsTrue = false;

            } catch (InputMismatchException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        boolean emailISTrue = true;
        while (emailISTrue){
            try {
                System.out.println("Напиши Email: ");
                String email = new Scanner(System.in).nextLine();
                if (email.matches(".*\\d.*") || !email.contains("@gmail.com")) {
                    throw new InputMismatchException(" email должен содержать буквы и @gmail.com");
                }else {
                    this.email=email;
                    emailISTrue = false;
                }
            } catch (InputMismatchException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber() {
        boolean pnISTrue = true;
        while (pnISTrue){
            try {
                System.out.println("Номер телефона начинается с +996\nНапишите номер телефона: ");
                String pNumber = new Scanner(System.in).nextLine();
                if (!pNumber.startsWith("+996") || !pNumber.matches(".*\\d.*")) {
                    throw new InputMismatchException("Номер телефона начинается с +996 & должен состоять из цифр! ");
                }
                this.phoneNumber=pNumber;
                pnISTrue = false;
            } catch (InputMismatchException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender() {

        boolean choose = true;
        System.out.println("Напишите пол читателя \n MALE /FEMALE");
        while (choose) {
            try {
                this.gender = Gender.valueOf(new Scanner(System.in).nextLine());
                choose = false;
            } catch (Exception e) {
                System.err.println("Напишите пол читателя  MALE /FEMALE");
            }
        }
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", gender=" + gender +
                '}';
    }
}
