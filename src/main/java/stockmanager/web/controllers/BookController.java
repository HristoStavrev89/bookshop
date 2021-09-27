package stockmanager.web.controllers;

import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stockmanager.dtos.viewDtos.bookDtos.ViewBookDto;
import stockmanager.services.interfaces.BookDataService;
import stockmanager.services.interfaces.BookService;

import java.util.Optional;

@RestController
@RequestMapping("/bookshop")
public class BookController {
    private final BookService bookService;
    private final BookDataService bookDataService;
    private final Gson gson;


    public BookController(BookService bookService, BookDataService bookDataService, Gson gson) {
        this.bookService = bookService;
        this.bookDataService = bookDataService;
        this.gson = gson;

    }


    @GetMapping("/books")
    public String getAllBooks() {
        return this.gson.toJson(this.bookService.allBooks());
    }

    @GetMapping("books/{bookId}")
    public String getBookData(@PathVariable String bookId) {
        return this.gson.toJson(this.bookDataService.findByBookId(bookId));
    }

    @GetMapping("books/{bookId}/buy/{buyBooksCount}")
    public String reserveBooks(@PathVariable String bookId, @PathVariable int buyBooksCount) {
       return this.gson.toJson(this.bookDataService.buyBooks(bookId, buyBooksCount));
    }

    @GetMapping("books/{bookId}/refillStock")
    public String refillBookStock(@PathVariable String bookId) {
        return this.gson.toJson(this.bookDataService.refillStock(bookId));
    }

}
