package stockmanager;

import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import stockmanager.dtos.seedDtos.BookDto;
import stockmanager.services.implementations.BookServiceImpl;
import stockmanager.services.interfaces.BookDataService;

import java.io.FileNotFoundException;
import java.io.FileReader;

@Component
public class AppInit implements CommandLineRunner {
    private static final String BOOKS_FILE_PATH = "src/main/resources/jsonImportData/books";

    private final Gson gson;
    private final BookServiceImpl bookService;


    public AppInit(Gson gson, BookServiceImpl bookService, BookDataService bookDataService) {
        this.gson = gson;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {

        this.seedBooks();


    }

    private void seedBooks() throws FileNotFoundException {
        BookDto[] bookDtos = this
                .gson
                .fromJson(new FileReader(BOOKS_FILE_PATH), BookDto[].class);



        this.bookService.seedBooks(bookDtos);
    }
}
