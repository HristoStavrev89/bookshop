package stockmanager.services.implementations;

import org.hibernate.annotations.NotFound;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stockmanager.dtos.viewDtos.bookDataDtos.ViewBookDataDto;
import stockmanager.entities.Book;
import stockmanager.entities.BookData;
import stockmanager.repositories.BookDataRepository;
import stockmanager.services.interfaces.BookDataService;

@Service
public class BookDataServiceImpl implements BookDataService {
    private static final int INITIAL_BOOKS_STOCK = 100;

    private final BookDataRepository bookDataRepository;
    private final ModelMapper modelMapper;



    @Autowired
    public BookDataServiceImpl(BookDataRepository bookDataRepository, ModelMapper modelMapper) {
        this.bookDataRepository = bookDataRepository;

        this.modelMapper = modelMapper;
    }


    /**
     * @param book
     * Create and save into the database BookData object for given book.
     * Every new BookData object receive a Book object and initial stock of 100 books at the beginning.
     */
    //Initialize
    @Override
    public void seedBookData(Book book) {
        BookData bookData = new BookData();
        bookData.setBook(book);
        bookData.setOnStock(INITIAL_BOOKS_STOCK);
        bookData.setAvailable(true);
        this.bookDataRepository.saveAndFlush(bookData);
    }

    /**
     * @param bookId
     * @return ViewBookDataDto
     * Getting single book from the database if there is book with such a ID.
     * If there is no such book with the given ID, it returns null.
     * The method parse at the end the result from Book to ViewBookDataDto object.
     */
    @Override
    public ViewBookDataDto findByBookId(String bookId) {
        BookData bookData = this.bookDataRepository.findByBookId(bookId).orElse(null);

        return this.modelMapper.map(bookData, ViewBookDataDto.class);

    }


    /**
     * @param bookId
     * @param count
     * @return ViewBookDataDto
     * OnStock property into the current BookData object is reduced, it depend of the buyed books quantity.
     */
    @Override
    public ViewBookDataDto buyBooks(String bookId, int count) {
        BookData bookData = this.bookDataRepository.findByBookId(bookId).orElse(null);
        int onStockResult = bookData.getOnStock() - count;
        if (onStockResult < 0) {
            bookData.setOnStock(0);
            bookData.setAvailable(false);
        } else {
            if (onStockResult == 0) {
                bookData.setOnStock(0);
                bookData.setAvailable(false);
            }
            bookData.setOnStock(onStockResult);
        }
        this.bookDataRepository.save(bookData);
        return this.modelMapper.map(bookData, ViewBookDataDto.class);
    }


    /**
     * @param bookId
     * @return ViewBookDataDto
     * Refill the quantity for the given book by ID to 100 books.
     */
    @Override
    public ViewBookDataDto refillStock(String bookId) {
        BookData bookData = this.bookDataRepository.findByBookId(bookId).orElse(null);
        bookData.setOnStock(INITIAL_BOOKS_STOCK);
        bookData.setAvailable(true);
        this.bookDataRepository.save(bookData);

        return this.modelMapper.map(bookData, ViewBookDataDto.class);
    }
}
