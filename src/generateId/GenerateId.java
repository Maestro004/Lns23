package generateId;

public class GenerateId {
    public static Long bookId = 0L;
    public static Long libraryId = 0L;
    public static Long readerId = 0L;

    public static long genBookId(){
        return ++bookId;
    }

    public static long genReaderId(){
        return ++readerId;
    }
    public static long genLibraryId(){
        return ++libraryId;
    }
}
