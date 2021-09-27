package stockmanager.services.interfaces;

import stockmanager.dtos.seedDtos.BookDto;
import stockmanager.dtos.viewDtos.bookDtos.ViewAllBooksDtos;
import stockmanager.dtos.viewDtos.bookDtos.ViewBookDto;
import stockmanager.entities.Book;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

public interface BookService {


    void seedBooks(BookDto[] bookDtos) throws FileNotFoundException;

    ViewAllBooksDtos allBooks();

    ViewBookDto findById(String bookId);
}
