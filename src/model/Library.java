package model;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Library {
    private Long id;
    private String name;
    private String address;
    private  List<Book>books;
    private List<Reader> readers;

    public Library(Long id, String name, String address, List<Book> books, List<Reader> readers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.books = books;
        this.readers = readers;
    }
    public Library(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        boolean isTrue =true;
        while (isTrue) {
            try {
                System.out.println("Напишите название библиотеки: ");
                String libraryName = new Scanner(System.in).nextLine();
                if (libraryName.matches(".*\\d.*")) {
                    throw new InputMismatchException("Название библиотеки состоит из букв  ");
                }
                this.name=libraryName;
                isTrue=false;
            }catch (InputMismatchException e){
                System.err.println(e.getMessage());
            }
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress() {
        boolean isTrue = true;
        while (isTrue) {
            try {
                System.out.println("Напишите адрес библиотеки");
                String address = new Scanner(System.in).nextLine();
                if (address.matches(".*\\d.*")) {
                    throw new InputMismatchException("Напишите адрес библиотеки! ");
                }
                this.address=address;
                isTrue=false;
            }catch (InputMismatchException e){
                System.err.println(e.getMessage());
            }
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                " " + books +"\n"+
                " " + readers ;
    }
}
