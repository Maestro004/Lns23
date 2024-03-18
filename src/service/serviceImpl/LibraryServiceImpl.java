package service.serviceImpl;

import model.Database;
import model.Library;
import service.LibraryService;

import java.util.List;


public class LibraryServiceImpl implements LibraryService {


    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        Database.libraries.addAll(libraries);
        return libraries;
    }

    @Override
    public List<Library> getAllLibraries() {
        return Database.libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        for (Library library : Database.libraries) {
            if (library.getId()==(id)) {
                return library;
            }
        }
        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        for (int i = 0; i <Database.libraries.size(); i++) {
            Library library1=Database.libraries.get(i);
            if (library1.getId()==(id)) {
                Database.libraries.set(i,library);
                return library;
            }
        }
        return null;
    }

    @Override
    public String deleteLibrary(Long id) {
        for (Library library : Database.libraries) {
            if (library.getId()==(id)) {
                Database.libraries.remove(library);
                return "Библиотека с ID " + id + " Успешно удалено.";
            }
        }
        return "Библиотека с ID " + id + " Не найдено.";

    }
}
