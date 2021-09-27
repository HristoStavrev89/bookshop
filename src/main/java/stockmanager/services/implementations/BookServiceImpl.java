package stockmanager.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stockmanager.dtos.seedDtos.BookDto;
import stockmanager.dtos.viewDtos.bookDtos.ViewAllBooksDtos;
import stockmanager.dtos.viewDtos.bookDtos.ViewBookDto;
import stockmanager.entities.Book;
import stockmanager.repositories.BookRepository;
import stockmanager.services.interfaces.BookDataService;
import stockmanager.services.interfaces.BookService;
import stockmanager.utils.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository repository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final BookDataService bookDataService;

    @Autowired
    public BookServiceImpl(BookRepository repository, ModelMapper modelMapper, ValidationUtil validationUtil, BookDataService bookDataService) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.bookDataService = bookDataService;
    }


    /**
     * @param bookDtos
     * @throws FileNotFoundException
     * Importing JSON with books into the database.
     */
    @Override
    public void seedBooks(BookDto[] bookDtos) throws FileNotFoundException {
        if (this.repository.count() != 0) {
            return;
        }
        Arrays.stream(bookDtos)
                .forEach(currentDto -> {
                    if (this.validationUtil.isValid(currentDto)) {
                        Book book = this.modelMapper.map(currentDto, Book.class);
                        if (this.repository.findByTitle(currentDto.getTitle()) == null) {
                            this.repository.saveAndFlush(book);
                            this.bookDataService.seedBookData(book);
                        }
                    } else {
                        this.validationUtil
                                .getViolations(currentDto)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                });
    }


    /**
     * @return ViewAllBooksDtos
     * Retrieving all books from the database and parse them to ViewAllBooks object
     * which is used for representation into the BookController.
     */
    @Override
    public ViewAllBooksDtos allBooks() {

        ViewAllBooksDtos allBooksDtos = new ViewAllBooksDtos();
        List<ViewBookDto> allBooks = this.repository.findAll()
                .stream()
                .map(book -> this.modelMapper.map(book, ViewBookDto.class))
                .collect(Collectors.toList());

        allBooksDtos.setAllBooks(allBooks);
        allBooksDtos.setCount(this.repository.count());
        return allBooksDtos;
    }


    /**
     * @param bookId
     * @return
     * Retrieving single book by id from the database. If the book exist the method
     *  will return ViewBookDto and null if there is no book with such a id.
     */
    @Override
    public ViewBookDto findById(String bookId) {
        Book book = this.repository.findById(bookId).orElse(null);
        return this.modelMapper.map(book, ViewBookDto.class);
    }
}
