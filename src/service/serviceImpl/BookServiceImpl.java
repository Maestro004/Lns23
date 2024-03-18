package service.serviceImpl;

import model.Book;
import model.Database;
import model.Library;
import service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public Book saveBook(Long libraryId, Book book) {
        for (Library library : Database.libraries) {
            if (library.getId() == libraryId) {
                library.getBooks().add(book);
            } else {
                System.out.println("Id not found!");
            }

        }
        return null;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        for (Library library : Database.libraries) {
            if (library.getId() == libraryId) {
                return library.getBooks();
            } else {
                System.out.println("Id not found");
            }
        }
        return null;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        for (Library library : Database.libraries) {
            if (library.getId() == libraryId) {
                for (Book book : library.getBooks()) {
                    if (book.getId() == bookId) {
                        return book;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for (Library library : Database.libraries) {
            if (library.getId() == (libraryId)) {
                for (Book book : Database.books) {
                    if (book.getId() == (bookId)) {
                        Database.books.remove(book);
                        return "Книга с ID" + bookId + "Успешно удалено.";
                    }
                }
            }
        }
        return "Книга с ID" + bookId + "Не найдено";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        for (Library library : Database.libraries) {
            if (library.getId() == (libraryId)) {
                Database.books.clear();

            }
        }

    }
}
