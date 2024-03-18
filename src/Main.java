import enums.Gender;
import generateId.GenerateId;
import model.Book;
import model.Database;
import model.Library;
import model.Reader;
import service.serviceImpl.BookServiceImpl;
import service.serviceImpl.LibraryServiceImpl;
import service.serviceImpl.ReaderServiceImpl;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**Задание учителя

Срок сдачи : 14.03.2024 / 11:00
ArrayList task.

Models
Library(id, name, address, List<Book>books, List<Reader>readers)
Book(id, name, author, Genre genre)
Reader(id, fullName, email, phoneNumber, Gender gender)
Database(List<Library>libraries, List<Book>books,List<Reader>readers)


     2. Methods



        LibraryService
List<Library>saveLibrary(List<Library>libraries);

List<Library>getAllLibraries();

Library getLibraryById(Long id);

Library updateLibrary(Long id, Library library);

String deleteLibrary(Long id);



BookService
Book saveBook(Long libraryId,Book book);

List<Book>getAllBooks(Long libraryId);

Book getBookById(Long libraryId, Long bookId);

String deleteBook(Long libraryId,Long bookId);

void clearBooksByLibraryId(Long libraryId);



ReaderService
void saveReader(Reader reader);

List<Reader> getAllReaders();

Reader getReaderById(Long id);

Reader updateReader(Long id, Reader reader);

void assignReaderToLibrary(Long readerId,Long libraryId);



Бардык методдор Main класска чакырылып, switch case аркылуу ирээттуу турдо консольго чыксын
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    1. Библиотека
                    2. Забронировать
                    3. Читатель
                    """);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> getLibrary(scanner);
                case 2 -> getBook(scanner);
                case 3 -> getReader(scanner);

            }
        }
    }

        public static void getLibrary(Scanner scanner){
            LibraryServiceImpl libraryService = new LibraryServiceImpl();
            try {
                boolean isTrue = true;
                while (isTrue) {
                    System.out.println("""
                            1. Сохранить библиотеку
                            2. Получить все библиотеки
                            3. Получить библиотеку по идентификатору
                            4. Обновить библиотеку
                            5. Удалить библиотеку по идентификатору
                            6. Выход
                                    """);
                    int choiceLibrary = scanner.nextInt();
                    switch (choiceLibrary) {
                        case 1 -> {
                            boolean isTrueSave = true;
                            while (isTrueSave) {
                                Library library = new Library();
                                library.setId(GenerateId.genLibraryId());
                                library.setName();
                                library.setAddress();
                                library.setReaders(Database.readers);
                                library.setBooks(Database.books);
                                List<Library> libraries = new ArrayList<>();
                                libraries.add(library);
                                libraryService.saveLibrary(libraries);

                                System.out.println("Успешно добавлено");
                                isTrueSave=false;



                            }
                        }
                        case 2 -> {
                            System.out.println(libraryService.getAllLibraries());
                        }
                        case 3 -> {
                            System.out.println("Напишите ID библиотеки: ");
                            System.out.println(libraryService.getLibraryById(scanner.nextLong()));
                        }
                        case 4 -> {
                            boolean isTrueLib = true;
                            while (isTrueLib) {
                                System.out.println("Напишите ID библиотеки:");
                                long updateScanner = scanner.nextLong();
                                Library library = new Library();
                                library.setId(updateScanner);
                                library.setName();
                                library.setAddress();
                                library.setReaders(Database.readers);
                                library.setBooks(Database.books);
                                System.out.println(libraryService.updateLibrary(updateScanner, library));
                                System.out.println("Успешно обновлено");
                                isTrueLib=false;

                            }
                        }
                        case 5 -> {
                            System.out.println("Напишите ID библиотеки: ");
                            System.out.println(libraryService.deleteLibrary(scanner.nextLong()));
                        }
                        case 6 -> {
                            isTrue = false;
                        }
                    }
                }

            } catch (InputMismatchException e) {
                System.err.println("Выбор 1-2-3-4-5-6");
            }
        }
        public static void getBook(Scanner scanner){
            BookServiceImpl bookService = new BookServiceImpl();

            try {

                boolean isTrue = true;
                while (isTrue) {
                    System.out.println("""
                            1. Сохранить книгу
                            2. Получите все книги
                            3. Получить книгу по идентификатору
                            4. Удалить книгу по идентификатору
                            5. Очистить книги по идентификатору библиотеки
                            6. Выход
                                          """);
                    int BookChoice = scanner.nextInt();
                    switch (BookChoice) {


                        case 1 -> {
                            boolean isTrueB = true;
                            while (isTrueB) {
                                Book book = new Book();
                                System.out.println("Напишите ID библиотеки: ");
                                long libraryId = scanner.nextLong();
                                book.setId(GenerateId.genBookId());
                                book.setName();
                                book.setAuthor();
                                book.setGenre();
                                System.out.println(bookService.saveBook(libraryId, book));
                                System.out.println("Успешно");
                                isTrueB=false;
                            }
                        }

                        case 2 -> {
                            System.out.println("Напишите ID библиотеки: ");
                            System.out.println(bookService.getAllBooks(scanner.nextLong()));
                        }

                        case 3 -> {
                            System.out.println("Напишите ID библиотеки и ID книги: ");
                            System.out.println(bookService.getBookById(scanner.nextLong(), scanner.nextLong()));
                        }

                        case 4 -> {
                            System.out.println("Напишите ID библиотеки: ");
                            long libID =scanner.nextLong();
                            System.out.println("Напишите ID книги: ");
                            System.out.println(bookService.deleteBook(libID, scanner.nextLong()));
                        }
                        case 5 -> {
                            System.out.println("Напишите ID библиотеки: ");
                            bookService.clearBooksByLibraryId(scanner.nextLong());
                        }
                        case 6 -> {
                            isTrue = false;
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.err.println(e.getMessage());
            }

        }
        public static void getReader(Scanner scanner){
            ReaderServiceImpl readerService = new ReaderServiceImpl();

            try {
                boolean isTrue = true;
                while (isTrue) {
                    System.out.println("""
                            1. Сохранить читателя
                            2. Получить всех читателей
                            3. Получить читателя по идентификатору
                            4. Обновить читалку
                            5. Назначьте читателя библиотеке.
                            6. Выход
                                    """);
                    int bookChoice = scanner.nextInt();
                    switch (bookChoice) {

                        case 1 -> {
                            boolean isTrue2=true;
                            while (isTrue2) {
                                Reader reader = new Reader();
                                reader.setId(GenerateId.genReaderId());
                                reader.setFullName();
                                reader.setEmail();
                                reader.setPhoneNumber();
                                reader.setGender();
                                System.out.println("Успешно добавлено");
                                readerService.saveReader(reader);
                                isTrue2=false;
                            }
                        }

                        case 2 -> {
                            System.out.println(readerService.getAllReaders());
                        }

                        case 3 -> {
                            System.out.println("Напишите ID читателя");
                            System.out.println(readerService.getReaderById(scanner.nextLong()));
                        }

                        case 4 -> {
                            Reader reader = new Reader();
                            System.out.println("Напишите ID читателя");
                            long id=scanner.nextLong();
                            reader.setId(id);
                            reader.setFullName();
                            reader.setEmail();
                            reader.setPhoneNumber();
                            reader.setGender();
                            System.out.println(readerService.updateReader(id,reader));

                        }

                        case 5 -> {
                            System.out.println("Запишите ID читателя и ID библиотеки");
                            readerService.assignReaderToLibrary(scanner.nextLong(), scanner.nextLong());
                        }

                        case 6 -> {
                            isTrue = false;
                        }
                    }
                }
            }catch (InputMismatchException e){
                System.err.println(e.getMessage());
            }
    }
}