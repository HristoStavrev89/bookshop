package stockmanager.services.interfaces;

import stockmanager.dtos.viewDtos.bookDataDtos.ViewBookDataDto;
import stockmanager.entities.Book;

public interface BookDataService {

    void seedBookData(Book book);

    ViewBookDataDto findByBookId(String bookId);

    ViewBookDataDto buyBooks(String bookId, int count);

    ViewBookDataDto refillStock(String bookId);
}
