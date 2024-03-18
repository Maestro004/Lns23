package service.serviceImpl;

import model.Database;
import model.Library;
import model.Reader;
import service.ReaderService;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public void saveReader(Reader reader) {
        Database.readers.add(reader);
        System.out.println(reader);
    }

    @Override
    public List<Reader> getAllReaders() {
        return Database.readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        for (Reader reader:Database.readers){
            if (reader.getId()==(id)){
                return reader;
            }
        }

        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (int i = 0; i <Database.readers.size(); i++) {
            if (Database.readers.get(i).getId()==(id)){
                Database.readers.set(i,reader);
                return reader;
            }

        }System.out.println("Успешно обновлено.");
        return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        for (Reader reader:Database.readers){
            if(reader.getId()==(libraryId)){
                for (Library library:Database.libraries){
                    if(library.getId()==(libraryId)){
                        library.setReaders(Database.readers);
                    }
                }
            }
        }

    }
}
