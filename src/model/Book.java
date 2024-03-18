package model;

import enums.Genre;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Book {

    private Long id;
    private String name;
    private String author;
    private Genre genre;

    public Book(Long id, String name, String author, Genre genre) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
    }
    public Book(){

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
        boolean isTrue = true;

        while (isTrue) {
            System.out.println("Напишите название книги");
            try {
                String title =new Scanner(System.in).nextLine();
                if (title.matches(".*\\d.*")){
                    throw new InputMismatchException("Название книги должно состоять из букв!");
                }
                this.name=title;
                isTrue=false;
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor() {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("Написать автора:");
            try {

                String author = new Scanner(System.in).nextLine();
                if (author.matches(".*\\d.*")) {
                    throw new InputMismatchException("Имя автора должно состоять из букв!");
                }
                this.author = author;
                isTrue = false;
            }catch (InputMismatchException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre() {
        boolean choose = true;
        System.out.println("Напишите жанр книги  "+ Arrays.toString(Genre.values()));
        while (choose) {
            try {
                this.genre = Genre.valueOf(new Scanner(System.in).nextLine());
                choose = false;
            } catch (Exception e) {
                System.err.println("написать жанр книги");
            }
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                '}';
    }
}